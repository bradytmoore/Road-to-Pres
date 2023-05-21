import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber;
    Font titleFont = new Font("Comic Sans", Font.PLAIN, 90);
    Font normalFont = new Font("Comic Sans", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3;
    JTextArea mainTextArea;
    int playerFav;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    ImageIcon logo = new ImageIcon("/Users/bradymoore/Desktop/211/RoadToPres/americanflag.jpeg");

    public static void main(String[] args){

        new Game();

    }

    public Game(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 900, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Road to Pres 2024");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.blue);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.blue);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 600, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.blue);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.blue);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.blue);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);


//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("Favorability:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);


        playerSetup();

    }
    public void playerSetup(){

        playerFav = 0;
        hpLabelNumber.setText("" + playerFav);

        debateStage();
    }

    public void debateStage(){
        position = "debateStage";
        mainTextArea.setText("Welcome to the 2024 Presidential Debate!. \nFirst Question is about how you would handle the Russia-Ukraine conflict. \n\nWhat is your answer?");
        choice1.setText("Enforce 'no-fly-zone' over Ukraine");
        choice2.setText("The current sanctions are enough");
        choice3.setText("Release the sanctions and leave it between Russia and Ukraine");

    }
    public void noflyZone(){
        position = "Enforce 'no-fly-zone'";
        mainTextArea.setText("Moderator: And what would you say to Americans who say that will lead to a global conflict? ");
        playerFav = playerFav -1;
        hpLabelNumber.setText(""+playerFav);
        choice1.setText("We're America we can do what we want.");
        choice2.setText("We have to do something.");
        choice3.setText("Our military is smart enough to not start a war.");

    }
    public void currentSan(){
        position = "Current Sanctions";
        mainTextArea.setText("What would you say to the Americans that say the sanctions are 'too harsh' or 'not enough'?");
        playerFav = playerFav +1;
        hpLabelNumber.setText(""+playerFav);
        choice1.setText("It is our best method to curb Russia's war efforts.");
        choice2.setText("I'm not against removing the SWIFT ban to alleviate the lives of the average Russian.");
        choice3.setText("I wanted war but my staff told me no.");

    }

    public void leaveBe(){
        position = "Leave it Be";
        mainTextArea.setText("Some say taking no stance is taking a stance with Russia.\nWhat do you think of that?");
        playerFav = playerFav - 2;
        hpLabelNumber.setText(""+playerFav);
        choice1.setText("It hurts our country too much to take a stance.");
        choice2.setText("Tax dollars shouldn't go to war.");
        choice3.setText("Things happen. Not our problem.");
    }

    public void debateStage2(){
        position = "debateStage2";
        mainTextArea.setText("Now onto the second Question.\nHow would you deal with America's current energy crisis?");
        choice1.setText("This is a sign that we need to transition to renewable energy to become energy independent.");
        choice2.setText("We should look to other partners for a better deal to get cheaper gas to more Americans.");
        choice3.setText("Everything will be fine once all this confusion goes away.");

    }
    public void rewnewEn(){
        position = "Rewewable Energy";
        mainTextArea.setText("What do you say to Americans who say it would be too expensive? ");
        playerFav = playerFav + 1;
        hpLabelNumber.setText(""+playerFav);
        choice1.setText("The cost may be high but the outcome will be worth it.");
        choice2.setText("Americans want to go green!");
        choice3.setText("I only want to turn some of the energy sector into renewable energy not all of it.");

    }
    public void partners(){
        position = "Other Partners";
        mainTextArea.setText("What partners are you thinking of?");
        playerFav = playerFav -1;
        hpLabelNumber.setText(""+playerFav);
        choice1.setText("While we have had troubles in the past we should look to those in our own neighborhood like Venezuela.");
        choice2.setText("I will work with the Gulf States to create a better deal than what we have now.");
        choice3.setText("Anyone besdies Russia would suffice.");


    }
    public void Wait(){
        position = "Wait it Out";
        playerFav = playerFav -2;
        hpLabelNumber.setText(""+playerFav);
        mainTextArea.setText("Do you agree with the position that 'waiting it out' will only fund those who are currently causing this crisis?");
        choice1.setText("It is still not our business no matter what is happening in the world. We should worry about Americans first.");
        choice2.setText("It's not funding them if we tell them not to use it for bad reasons.");
        choice3.setText("The United States has never been opposed to making money off of a couple dictators why stop now.");

    }

    public void win(){
        position = "win";

        mainTextArea.setText("You've won the election!\nCongratulations on being the new President of the United States of America!");

        choice1.setText("Play Again");
        choice2.setText("Leave");
        choice3.setText("");


    }
    public void lose(){
        position = "lose";

        mainTextArea.setText("You lost!\n\nGAME OVER");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }
//    public void ending(){
//        position = "ending";
//
//        mainTextArea.setText("\n\nTHE END");
//
//        choice1.setText("");
//        choice2.setText("");
//        choice3.setText("");
//        choice1.setVisible(false);
//        choice2.setVisible(false);
//        choice3.setVisible(false);
//
//    }




    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }


    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(position){
                case "debateStage":
                    switch(yourChoice){
                        case "c1":
                            noflyZone();
                            break;

                        case "c2":
                            currentSan();
                            break;

                        case "c3":
                            leaveBe();
                            break;
                    }
                    break;
                case "Enforce 'no-fly-zone'":
                    switch(yourChoice){
                        case "c1":
                            debateStage2();
                            break;
                        case "c2":
                            debateStage2();
                            break;
                        case "c3":
                            debateStage2();
                            break;
                    }
                    break;
                case "Current Sanctions":
                    switch(yourChoice){
                        case "c1":
                            debateStage2();
                            break;
                        case "c2":
                            debateStage2();
                            break;
                        case "c3":
                            debateStage2();
                            break;

                    }
                    break;
                case "Leave it Be":
                    switch(yourChoice){
                        case "c1":
                            debateStage2();
                            break;
                        case "c2":
                            debateStage2();
                            break;
                        case "c3":
                            debateStage2();
                            break;

                    }
                    break;
                case "debateStage2":
                    switch(yourChoice){
                        case "c1":
                            rewnewEn();
                            break;
                        case "c2":
                            partners();
                            break;
                        case "c3":
                            Wait();
                            break;
                    }
                    break;
                case "Renewable Energy":
                    switch(yourChoice){
                        case "c1":
                            if(playerFav >= 2){
                                win();
                        }
                            else{
                                lose();
                            }
                        case "c2":
                            if(playerFav >= 2){
                                win();
                            }
                            else{
                                lose();
                            }
                            break;
                        case "c3":
                            if(playerFav >= 2){
                                win();
                            }
                            else{
                                lose();
                            }
                            break;
                    }
                    break;
                case "Other Partners":
                    switch(yourChoice){
                        case "c1":
                            if(playerFav >= 2){
                                win();
                            }
                            else{
                                lose();
                            }
                        case "c2":
                            if(playerFav >= 2){
                                win();
                            }
                            else{
                                lose();
                            }
                            break;
                        case "c3":
                            if(playerFav >= 2){
                                win();
                            }
                            else{
                                lose();
                            }
                    }
                    break;
                case "Wait it Out":
                    switch(yourChoice){

                        case "c1":
                            if(playerFav >= 5){
                                win();
                            }
                            else{
                                lose();
                            }
                        case "c2":
                            if(playerFav >= 5){
                                win();
                            }
                            else{
                                lose();
                            }
                            break;
                        case "c3":
                            if(playerFav >= 5){
                                win();
                            }
                            else{
                                lose();
                            }
                            break;
                    }
                    break;

                case "win":
                    switch(yourChoice){
                        case "c1":
                            debateStage2();
                    }
                    break;

            }


        }
    }


}
