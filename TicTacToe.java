import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel buttons_panel = new JPanel();
    JLabel text_field = new JLabel(); // TO display a text on our Jframe
    JButton[] buttons = new JButton[9];  //An Array for buttons we need
    boolean player1_turn; //true for player one's turn and false for player two's turn

    TicTacToe (){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //To terminate the Jframe on the X press
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50)); // The code sets the background color of the content pane to a dark gray color.
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,255,0)); //Text Color
        text_field.setFont(new Font("Ink Free",Font.BOLD,75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("TIC-TAC-TOE");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        buttons_panel.setLayout(new GridLayout(3,3));
        buttons_panel.setBackground(new Color(150,150,150));

        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttons_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this); //when the button is clicked the action listener of the class is invoked.

        }



        title_panel.add(text_field); // To add text field to out title panel
        frame.add(title_panel,BorderLayout.NORTH); // The titel Panel takes the entire frame. So since we're using border layout we can
        //we can specify a border where this title panel can stick to.
        frame.add(buttons_panel);
        firstturn();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0; i<9; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){  //For settings alternative turns
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("O's Turn");
                        check();

                    }
                    else tieconditions();
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("X's Turn");
                        check();

                    }
                    else tieconditions();
                }
            }
        }

    }
    public void firstturn(){
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();  //prints line number and class name where the exception occurred
        }

        if(random.nextInt(2)==0){ //for setting random turns for O and X
            player1_turn = true;
            text_field.setText("X's Turn");

        }
        else{
            player1_turn = false;
            text_field.setText("O's Turn");
        }
    }

    public void check(){
        //win conditions for X
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[1].getText()=="X")&&
                        (buttons[2].getText()=="X")
        ){
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X")&&
                        (buttons[7].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[3].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X")&&
                        (buttons[5].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }
        //Win Conditions for O
        if(
                        (buttons[0].getText()=="O")&&
                        (buttons[1].getText()=="O")&&
                        (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }
        if(
                        (buttons[3].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }
        if(
                        (buttons[6].getText()=="O")&&
                        (buttons[7].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }
        if(
                        (buttons[0].getText()=="O")&&
                        (buttons[3].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }
        if(
                        (buttons[1].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }
        if(
                        (buttons[2].getText()=="O")&&
                        (buttons[5].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }
        if(
                        (buttons[0].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }
        if(
                        (buttons[2].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }

    }
    public void xWins(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);

        }
        text_field.setText("X WINS");
    }
    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);

        }
        text_field.setText("O WINS");

    }
        public void tieconditions(){
        for(int i=0; i<9; i++){
           //if 1 of 9 buttons text is blank
            if(buttons[i].getText().isBlank()){
                break; //tie conditions is not satisfied
            }
            //if both 9 buttons are not blank
            if(i==8){
                disablebuttons();
                text_field.setText("The GAME IS TIED");
            }
        }
    }
    public void disablebuttons(){
        for(int i=0; i<9;i++){
            buttons[i].setEnabled(false);
        }
    }


}