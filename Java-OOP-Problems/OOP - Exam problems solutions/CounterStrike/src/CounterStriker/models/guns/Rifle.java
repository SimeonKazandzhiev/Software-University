package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bulletsPerFire = 10;
        if(super.getBulletsCount() < bulletsPerFire){
            return 0;
        }else {
            int bulletsLeft = super.getBulletsCount() - bulletsPerFire;
            super.setBulletsCount(bulletsLeft);
            return bulletsPerFire;
        }
    }
}
