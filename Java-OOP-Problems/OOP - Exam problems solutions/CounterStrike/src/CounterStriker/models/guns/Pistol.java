package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bulletsPerFire = 1;
        if(super.getBulletsCount() < bulletsPerFire){
            return 0;
        }else {
            int bulletsLeft = super.getBulletsCount() - bulletsPerFire;
            super.setBulletsCount(bulletsLeft);
            return bulletsPerFire;
        }
    }
}
