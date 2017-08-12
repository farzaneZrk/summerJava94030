package entities;

public enum Grades {
	
    O, E, A, P, D, T, Default;
	
    public boolean isBetter(Grades grade2){
        if (this.ordinal() < grade2.ordinal())
            return false;
        else
            return true;
    } 
}