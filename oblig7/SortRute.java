import javafx.scene.paint.Color;

public class SortRute extends Rute{
  public SortRute(Labyrint labyrint, int rad, int kolonne){
    super(labyrint,rad, kolonne);
    firkant.setFill(Color.BLACK);
  }
  @Override
  public void gaa(String vei, Rute komFra){

  }
  public String tilTegn(){
    return "#";
  }
}
