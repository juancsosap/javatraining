package netec.oca.getstarted;

public class Game {
    
    public static void main(String[] args) {
        
        Bala bala = new Explosivas();
        Mira mira = new Telescopica();
        
        Arma rifle = new Arma(bala, mira);
        
        System.out.println(rifle.disparar());
        
    }
    
}

class Arma {
    
    private Bala bala;
    private Mira mira;
    
    public Arma(Bala b, Mira m) {
        bala = b;
        mira = m;
    }
    
    public int disparar() {
        return bala.getDano() * mira.getDano();
    }
    
}

interface Bala {
    int getDano();
}

class NoBala implements Bala {

    @Override
    public int getDano() {
        return 0;
    }
    
}

class Pintura implements Bala {
    
    @Override
    public int getDano() {
        return 1;
    }
    
}

class Normales implements Bala {
    
    @Override
    public int getDano() {
        return 10;
    }
    
}

class Explosivas implements Bala {
    
    @Override
    public int getDano() {
        return 100;
    }
    
}

abstract class Mira {
    
    protected int dano = 0;
    
    public int getDano() {
        return dano;
    }
    
    public void observar() {
        System.out.println("Mirando el objetivo");
    }
    
    public abstract void retirar();
    
}

class NoMira extends Mira {
    
    @Override
    public void retirar() {
        System.out.println("No hay nada que retirar");
    }
    
}

class Laser extends Mira {
    
    public Laser() {
        dano = 10;
    }
    
    @Override
    public void retirar() {
        System.out.println("Retirando Mira");
    }
    
}

class Telescopica extends Mira {
    
    public Telescopica() {
        dano = 20;
    }
    
    @Override
    public void retirar() {
        System.out.println("Retirando Mira");
    }
    
}