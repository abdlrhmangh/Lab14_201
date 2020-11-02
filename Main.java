package sample;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage)  {

        primaryStage.setTitle("ShowPolygon");
        //  the text that shows as the program name


        Text text = new Text("STOP");
        text.setFont(Font.font(80));
        text.setFill(Color.WHITE);
        //  setting up the color so I can pass it


        // create a stack pane and passing the polygon that we are
        // creating in the method MyPolygon and the text above as
        // a parameters
        StackPane stack_pane = new StackPane(new MyPolygon(), text);

        // create a scene which is the space that we will put
        // the stuff we create in
        Scene scene = new Scene(stack_pane, 400, 300);

        // set the scene, that means we are setting the scene above
        // and showing it so that it get displayed
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}


class MyPolygon extends Pane {

    private void paint() {
        Polygon polygon = new Polygon();


        polygon.setFill(Color.RED);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();
        //setting the colors and creating the list that will
        //contain the polygon points


        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        // setting up the center and the radius of the polygon


        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8 + (Math.PI / 8)));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8 + (Math.PI / 8)));
        }
        // here we creating the points of the polygon and we are adding Pi/8
        //to shift the polygon and make similar to a stop sign

        getChildren().clear();
        getChildren().add(polygon);


    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }


}

