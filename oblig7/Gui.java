import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;

public class Gui extends Application{

    Labyrint labyrint;
    Rute[][] brett;
    static Text tekst;
    int numLosning = 0;
    int antLosning = 0;
    Lenkeliste<String> losninger;
    String losning;
    boolean[][] losningbrett;
    BorderPane pane = new BorderPane();


    class LosningBehandler implements EventHandler<MouseEvent>{

      @Override
      public void handle(MouseEvent e){
      try{
        ((Rute)e.getSource()).finnUtVei();
        losninger = ((Rute)e.getSource()).hentUtveier();
        ((Rute)e.getSource()).tomUtvei();

        antLosning = losninger.stoerrelse();
        numLosning = 0;
        losning = losninger.hent(numLosning);

        losningbrett = Gui.this.losningStringTilTabell(losning, labyrint.hentRader(), labyrint.hentKolonner());

        for (int i = 0;  i < labyrint.hentRader();  i++) {
          for(int j = 0; j < labyrint.hentKolonner(); j++){
              Rute r = brett[i][j];
              if(r instanceof HvitRute){r.besoktTilNull();}
              if(losningbrett[i][j]){
                  brett[i][j].setVisible(true);

          }
          }
        }
        //tekst.setText("Losning " + (numLosning+1) + " av " + losninger.stoerrelse() + " losninger");
      } catch (UgyldigListeIndeks er){
        //tekst.setText("Det finnes ingen losninger");
      }
    }
    }

    class Stoppbehandler implements EventHandler<ActionEvent>{
      @Override
      public void handle(ActionEvent e){
      Platform.exit();
      }
    }


        static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
            boolean[][] losning = new boolean[hoyde][bredde];
            java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
            java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
            while (m.find()) {
                int x = Integer.parseInt(m.group(1));
                int y = Integer.parseInt(m.group(2));
                losning[y][x] = true;
            }
            return losning;
        }

    @Override
    public void start(Stage teater){
      File file = new FileChooser().showOpenDialog(teater);
      try {
          labyrint = Labyrint.lesFraFil(file);
      } catch (FileNotFoundException e) {
          System.out.printf("Kan ikke lese fra filen");
          System.exit(1);
      }

      brett = labyrint.hentLabyrint();

      GridPane rutenett = new GridPane();
        pane.setCenter(rutenett);
      //LosningBehandler visLosning = new LosningBehandler();

      System.out.println(labyrint.hentRader() + "!" + labyrint.hentKolonner());


      for (int i = 0;  i < labyrint.hentRader();  i++){
        for(int j = 0; j < labyrint.hentKolonner(); j++){
          Rute rute = brett[i][j];
          rutenett.add(rute, j, i);
          /*
          if(rute instanceof HvitRute){
            rute.setOnMouseClicked(visLosning);
          }
          */
        }
      }
      int xpos = labyrint.hentRader()*5-40;
      int ypos = labyrint.hentKolonner()*10+40;

      tekst = new Text("Velg en rute");
      tekst.setFont(new Font(25));
      pane.setBottom(tekst);
      //tekst.setLayoutX(300);
      //tekst.setLayoutY(ypos+300);

        Button stoppknapp = new Button("Stopp");
        pane.setTop(stoppknapp);
        //stoppknapp.setLayoutX(xpos+140); stoppknapp.setLayoutY(ypos+140);
        Stoppbehandler stopp = new Stoppbehandler();
        stoppknapp.setOnAction(stopp);

      //Pane pane = new Pane();
  	  //pane.getChildren().addAll(rutenett,stoppknapp,tekst);
      //pane.getChildren().add(rutenett);
      //pane.getChildren().add(stoppknapp);
      //pane.getChildren().add(tekst);

  	  Scene scene = new Scene(pane);


      teater.setTitle("Labyrint");
      teater.setScene(scene);
      teater.show();
    }

    public static void main(String[] args) {
      launch(args);
    }
}
