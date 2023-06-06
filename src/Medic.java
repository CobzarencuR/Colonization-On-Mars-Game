import java.util.SortedMap;

public class Medic extends Human implements Movement{

    public Medic(byte x,byte y,String name,int age)
    {

        this.x=x;
        this.y=y;
        this.name=name;
        this.age=age;
        this.hasMoved=false;

    }
    public void setPosition()
    {
        this.x=5;
        this.y=5;
    }
    public void heal(Human h1)
    {
        if(h1.HP<=60) {
            h1.HP += 40;
        }else{
            h1.HP=100;
        }
    }
    public boolean isColonist() {
        return false;
    }
    public boolean isEnginner() {
        return false;
    }
    public boolean isMedic() {
        return true;
    }

}