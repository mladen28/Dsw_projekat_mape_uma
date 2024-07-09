package raf.dsw.gerumap.ErrorFactory;

public class Error
{
    public Errors errType;
    public String poruka;

    public Error(Errors errType, String poruka)
    {
        this.errType = errType;
        this.poruka = poruka;
    }
    public String getPoruka() {
        return this.poruka;
    }

    @Override
    public String toString() {
        return "[" + errType.toString() + "]" + "[" + poruka + "]" + "\n";
    }
}
