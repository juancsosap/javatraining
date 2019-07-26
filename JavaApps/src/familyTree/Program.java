package familyTree;

import java.util.Arrays;

import GenericDAO.*;

public class Program {
    public static void main(String[] args) {
    	FullDAO<Person, Integer> dao = new FullDAOMemory<>();
    	
    	Person jlsm = new Person("José", Gender.MALE);
    	Person mmpe = new Person("Mauren", Gender.FEMALE);
    	Person vmpb = new Person("Victor", Gender.MALE);
    	Person bapb = new Person("Beatriz", Gender.FEMALE);
    	
    	dao.create(Arrays.asList(jlsm, mmpe, vmpb, bapb));
        
    	Person jcsp = new Person("Juan", Gender.MALE);
        Person agpp = new Person("Ana", Gender.FEMALE);
        
        dao.create(Arrays.asList(jcsp, agpp));
        
        jcsp.addParents(jlsm, mmpe);
        agpp.addParents(vmpb, bapb);
        
        Person vvmp = new Person("Vinny", Gender.FEMALE);
        Person mmsm = new Person("Marianela", Gender.FEMALE);
        Person adpp = new Person("Duberly", Gender.FEMALE);
        
        dao.create(Arrays.asList(vvmp, mmsm, adpp));
        
        vvmp.addParents(jlsm, mmpe);
        mmsm.addParents(jlsm);
        adpp.addParents(vmpb, bapb);
        
        jcsp.addRelations(RelType.COUPLE, agpp);
        
        Person sesp = new Person("Sarah", Gender.FEMALE);
        Person jasp = new Person("Jadash", Gender.FEMALE);
        
        dao.create(Arrays.asList(sesp, jasp));
        
        sesp.addParents(jcsp, agpp);
        jasp.addParents(jcsp, agpp);
        
        Person jmrp = new Person("Miguel", Gender.MALE);
        Person hhsm = new Person("Haniel", Gender.MALE);
        
        dao.create(Arrays.asList(jmrp, hhsm));
        
        jmrp.addParents(adpp);
        hhsm.addParents(mmsm);
        
        System.out.println(new People(dao.retrive().stream()));
        
        System.out.println("-----------UNCLES------------");
        System.out.println(sesp.getType(RelType.PARENT).getSiblings());
        
        System.out.println("--------GRAND FATHERS--------");
        System.out.println(sesp.getType(RelType.PARENT).getType(RelType.PARENT).males());
        
        System.out.println("-----------COUSINS-----------");
        System.out.println(sesp.getType(RelType.PARENT).getSiblings().getType(RelType.CHILD));
        
    }
}