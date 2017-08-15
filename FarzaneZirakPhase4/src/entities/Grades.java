package entities;

public enum Grades {
	
    O, /* Outstanding */
	E, /* Exceeds Expectations */
	A, /* Acceptable */
	P, /* Poor */
	T, /* Troll */
	Default; /* "N/A" */
	
    public boolean isBetter(Grades grade2){
        if (this.ordinal() < grade2.ordinal())
            return false;
        else
            return true;
    } 
}