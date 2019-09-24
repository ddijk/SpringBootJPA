package com.example.h2.user;

import com.example.h2.user.opal.FiEntity;
import com.example.h2.user.opal.InsuranceParty;
import com.example.h2.user.opal.InsurancePartyPK;
import com.example.h2.user.opal.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserEntityManagerCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserEntityManagerCommandLineRunner.class);
    public static final String INSURED = "insured";
    public static final String BENEFICIARY = "beneficiary";

    private int pk=1;

    @Autowired
    private UserService userService;

    @Autowired
    FiRepository fiRepository;

    @Autowired
    PersonRepo personRepo;

    @Autowired
    InsurancePartyRepo insurancePartyRepo;
//    @Autowired
//    private UserRepository userRepository;

    @Override
    public void run(String... args) {

        log.info("-------------------------------");
        log.info("Adding Tom as Admin");
        log.info("-------------------------------");


        FiEntity f1 = createFi("interpolis");
        FiEntity f2 = createFi("achmea");

        List<FiEntity> fiEntityList = new ArrayList<>();
        fiEntityList.add(f1);
        fiEntityList.add(f2);
        List<FiEntity> fiEntities = fiRepository.saveAll(fiEntityList);
        System.out.println("Save fiEntities: " + fiEntities);

        PersonEntity c1 = createPerson("client_1");
        PersonEntity p1 = createPerson("partner_1");
        PersonEntity c2 = createPerson("client_2");
        PersonEntity p2 = createPerson("partner_2");

        List<PersonEntity> personEntityList = new ArrayList<>();
        personEntityList.add(p1);
        personEntityList.add(p2);
        personEntityList.add(c1);
        personEntityList.add(c2);
        List<PersonEntity> personEntities = personRepo.saveAll(personEntityList);

        System.out.println("Save personEntities: " + personEntities);

        // partner verzekerd voor overlijden client 1
        InsuranceParty ip1 = createInsuranceParty(f1, c1, INSURED);
        InsuranceParty ip2 = createInsuranceParty(f1, p1, BENEFICIARY);

        //   kruislings: beide verzekerd op elkaars leven
        InsuranceParty ip3 = createInsuranceParty(f2, c2, INSURED);
        InsuranceParty ip4 = createInsuranceParty(f2, c2, BENEFICIARY);
        InsuranceParty ip5 = createInsuranceParty(f2, p2, INSURED);
        InsuranceParty ip6 = createInsuranceParty(f2, p2, BENEFICIARY);

        List<InsuranceParty> insuranceParties = new ArrayList<>();
        insuranceParties.add(ip1);
        insuranceParties.add(ip2);
        insuranceParties.add(ip3);
        insuranceParties.add(ip4);
        insuranceParties.add(ip5);
        insuranceParties.add(ip6);
        insurancePartyRepo.saveAll(insuranceParties);





    }

    private InsuranceParty createInsuranceParty(FiEntity fi, PersonEntity p, String type) {
        InsurancePartyPK pk = new InsurancePartyPK();
        pk.setFiId(fi.getId());
        pk.setPersonId(p.getId());
        pk.setType(type);
        InsuranceParty insuranceParty = new InsuranceParty();
        insuranceParty.setInsurancePartyPK(pk);
        return insuranceParty;
    }

    private PersonEntity createPerson(String name) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(pk++);
        personEntity.setNaam(name);

        return personEntity;
    }

    FiEntity createFi(String name) {
        FiEntity f1 = new FiEntity();
        f1.setId(pk++);
        f1.setNaam(name);

        return f1;
    }
}
