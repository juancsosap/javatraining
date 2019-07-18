package familyTree;

public class Program {
    public static void main(String[] args) {
    	Person jlsm = new Person("José", Gender.MALE);
    	Person mmpe = new Person("Mauren", Gender.FEMALE);
    	Person vmpb = new Person("Victor", Gender.MALE);
    	Person bapb = new Person("Beatriz", Gender.FEMALE);
    	
        Person jcsp = new Person("Juan", Gender.MALE);
        Person agpp = new Person("Ana", Gender.FEMALE);
        
        jcsp.addParents(jlsm, mmpe);
        agpp.addParents(vmpb, bapb);
        
        Person vvmp = new Person("Vinny", Gender.FEMALE);
        Person mmsm = new Person("Marianela", Gender.FEMALE);
        Person adpp = new Person("Duberly", Gender.FEMALE);
        
        vvmp.addParents(jlsm, mmpe);
        mmsm.addParents(jlsm);
        adpp.addParents(vmpb, bapb);
        
        jcsp.addRelations(RelType.COUPLE, agpp);
        
        Person sesp = new Person("Sarah", Gender.FEMALE);
        Person jasp = new Person("Jadash", Gender.FEMALE);
        
        sesp.addParents(jcsp, agpp);
        jasp.addParents(jcsp, agpp);
        
        Person jmrp = new Person("Miguel", Gender.MALE);
        Person hhsm = new Person("Haniel", Gender.MALE);
        
        jmrp.addParents(adpp);
        hhsm.addParents(mmsm);
        
        System.out.println("-----------UNCLES------------");
        System.out.println(sesp.getType(RelType.PARENT).getSiblings());
        
        System.out.println("--------GRAND FATHERS--------");
        System.out.println(sesp.getType(RelType.PARENT).getType(RelType.PARENT).males());
        
        System.out.println("-----------COUSINS-----------");
        System.out.println(sesp.getType(RelType.PARENT).getSiblings().getType(RelType.CHILD));
        
    }
}