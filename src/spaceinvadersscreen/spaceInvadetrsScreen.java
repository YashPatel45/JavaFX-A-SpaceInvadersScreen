/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvadersscreen;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Yash Patel
 */
public class spaceInvadetrsScreen extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(950, 600); // Set canvas Size in Pixels
        stage.setTitle("FXGraphicsTemplate"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scanner input = new Scanner(System.in);

        //data types
        int row, column, lives, location, color, x, y;
        double score;

        //Get rows from the user
        System.out.println("How many rows of alines you want ? ");
        row = input.nextInt();

        //Get column from user
        System.out.println("How many columns of alines you want ? ");
        column = input.nextInt();

        //Get a score from user
        System.out.println("Please enter your score: ");
        score = input.nextDouble();

        //Get how many lives user have
        System.out.println("Please enter how many lives you have: ");
        lives = input.nextInt();

        //Get a position of spaceship from user
        System.out.println("The x-position of the player’s spaceship: ");
        location = input.nextInt();

        //Get a color of spaceship from user
        System.out.println("The color of the player’s spaceship (e.g. 1=red, 2=blue, 3=green): ");
        color = input.nextInt();

        //Display Background 
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 950, 600);

        //Display the score inputed by user
        String presentScore = String.format("Score  ");
        String scoreOutput = String.format("%.0f", score);
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("System", 15));
        gc.fillText(presentScore, 20, 25);
        gc.setFill(Color.GREENYELLOW);
        gc.setFont(new Font("System", 15));
        gc.fillText(scoreOutput, 70, 25);

        //Display the Lives inputed by user 
        String presentLives = String.format("Lives  ");
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("System", 15));
        gc.fillText(presentLives, 760, 25);

        //FOR loop display the alines   
        for (x = 1; x <= row; x++) {
            for (y = 1; y <= column; y++) {
                Image img = new Image("img1.jpg");
                gc.drawImage(img, 100 * x, 50 * y);
                /*
                gc.setFill(Color.WHITE);
                gc.fillOval(100 * x, 50 * y, 30, 30);
                 */
            }
            System.out.println();
        }

        //FOR loop condition display the lives 
        //inputed by user
        for (int a = 0; a <= lives - 1; a++) {
            gc.setFill(Color.RED);
            gc.fillOval(810 + 30 * a, 8, 25, 25);
        }

        //FOR loop display the house which prevent the spaceship
        for (int b = 1; b <= 5; b++) {
            Image img = new Image("house.jpg");
            gc.drawImage(img, 150 * b, 450);
            /*
            gc.setFill(Color.DARKGRAY);
            gc.fillRect(100 + 140 * b, 450, 65, 20);
            */
        }

        //SWITCH condition display the spaceship with one color(1 or 2 or 3)
        //AND display where user input the location of spaceship
        switch (color) {
            case 1:
                gc.setFill(Color.RED);
                gc.fillRect(location, 520, 65, 20);
                gc.fillRect(location + 23, 510, 20, 15);
                break;
            case 2:
                gc.setFill(Color.BLUE);
                gc.fillRect(location, 520, 65, 20);
                gc.fillRect(location + 23, 510, 20, 15);
                break;
            case 3:
                gc.setFill(Color.GREEN);
                gc.fillRect(location, 520, 65, 20);
                gc.fillRect(location + 23, 510, 20, 15);
                break;
        }

        //FOR loop disaly the bullets
        for (int d = 0; d <= 10; d++) {
            gc.setFill(Color.BISQUE);
            gc.fillOval(Math.random() * location, 400, 5, 15);
        }

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
