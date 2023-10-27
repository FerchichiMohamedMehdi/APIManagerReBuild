package com.example.apimanagerrebuild.services;

import com.example.apimanagerrebuild.dto.AffectationDTO;
import com.example.apimanagerrebuild.exception.NullException;
import com.example.apimanagerrebuild.models.Affectation;
import com.example.apimanagerrebuild.models.Application;
import com.example.apimanagerrebuild.models.Intervenant;
import com.example.apimanagerrebuild.repositories.AffectationRepository;
import com.example.apimanagerrebuild.repositories.ApiRepository;
import com.example.apimanagerrebuild.repositories.ApplicationRepository;
import com.example.apimanagerrebuild.repositories.IntervenantRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AffectationService {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	AffectationRepository afRepo;
	@Autowired
	ApiRepository apiRepo;
	@Autowired
	IntervenantRepository iRepo;
	@Autowired
	ApplicationRepository appRepo;
	@Autowired ApiService aService;
	
	public AffectationDTO ToDto(Affectation af) {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		AffectationDTO afDto = new AffectationDTO();
		afDto = modelMapper.map(af, AffectationDTO.class);
		return afDto;
			}
	public AffectationDTO ToDTO(Affectation af) {
		AffectationDTO afDto = new AffectationDTO();
		afDto.setAdresseIP(af.getAdressesIP());
		List<Long> ap =new ArrayList<>();
		for(Application a:af.getApplications()) {
			ap.add(a.getIdApplication());
		}
		afDto.setApps(ap);
		List<Long> cl =new ArrayList<>();
		for(Intervenant a:af.getClients()) {
			cl.add(a.getIdIntervenant());
		}
		afDto.setClients(cl);
		afDto.setDateAffectation(af.getDateAffectation());
		afDto.setIdAffectation(af.getIdAffectation());
		afDto.setIdApi(af.getApi().getIdApi());
		return afDto;
		
	}
	
	public Affectation toEntity(AffectationDTO afdto) {
		Affectation af = new Affectation();
		af.setAdressesIP(afdto.getAdresseIP());
		LocalDate today = LocalDate.now( ZoneId.of( "America/Montreal" ) ) ;
		af.setDateAffectation(today);
		List<Long> apps= afdto.getApps();
		List<Long> clients = afdto.getClients();
		List<Application> applications = new ArrayList<>() ;
		List<Intervenant> cl =new ArrayList<>() ;
	
			if(apps==null) {
				af.setApplications(null);
			}else {
				for(Long s:apps ) {
			Application app = appRepo.findByIdApplication(s);
			
			applications.add(app);
		   af.setApplications(applications);
			}
		}
		for(Long i:clients ) {
			Intervenant c = iRepo.findByIdIntervenant(i);
			cl.add(c);
		   af.setClients(cl);
		}
		//à rectifier
		af.setApi(aService.getApiById(afdto.idApi));
		return af;
	    
	}
	public Affectation ajouter(AffectationDTO afdto) {
		Affectation af = new Affectation();
		
		 afRepo.save(toEntity(afdto));
		return af;
		
	}
	public List<AffectationDTO> listerAffectations(){
		return afRepo.findAll()
				.stream()
				.map(this::ToDTO)
				.collect(Collectors.toList());
	}
	public List<Affectation> getAll(){
		return afRepo.findAll();
	}
	public int NbrAffectations() {
		return afRepo.findAll().size();
	}
	public void UpdateAffectation(AffectationDTO afDTO,Long id) {
	 	Affectation af  = afRepo.findByIdAffectation(id);
    	if(afDTO!=null) {
    		af = afRepo.save(af);
    	}
    	else {
    		throw new NullException("affectation  null");
    	}
    }
	public void deleteAf(Long id) {
		afRepo.deleteById(id);
	}
	public AffectationDTO getAffectation(long id) {
		Affectation af = afRepo.findByIdAffectation(id);
		return ToDto(af);
	}
	
	
}
