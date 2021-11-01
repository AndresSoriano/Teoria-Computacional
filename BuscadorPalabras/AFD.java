import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AFD extends JFrame{

	public AFD(){
		super("Automata AFD");
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void paint(Graphics g){
		super.paint(g);
		/*-----Comenzando a dibujar lineas de estados "RECTAS"-----*/
		g.setColor(Color.BLACK);
		
		g.drawLine(20, 420, 75, 325);// ->A

		/*Estado A*/
		g.drawLine(110, 310, 210, 185);//A->B
		g.drawLine(110, 350, 225, 460);//A->C
		g.drawArc(15, 285, 60, 60, 35, 230);//A->A

		/*Estado B*/
		g.drawArc(205, 125, 50, 60, 325, 325);//B->B
		g.drawArc(100, 150, 480, 360, 115, 60);//B->A
		g.drawLine(270, 185, 370, 185);//B->D

		/*Estado D*/
		g.drawLine(420, 185, 530, 185);//D->F
		g.drawLine(270, 215, 370, 215);//D->B
		g.drawLine(245, 430, 370, 225);//D->C
		g.drawArc(85, 85, 340, 550, 35, 140);//D->A

		/*Estado F*/
		g.drawArc(70, 40, 515, 650, 35, 140);//F->A
		g.drawArc(203, 145, 385, 220, 40, 110);//F->B
		g.drawLine(260, 435, 530, 215);//F->C
		g.drawLine(555, 220, 555, 435);//F->G

		/*Estado C*/
		g.drawLine(265, 450, 390, 450);//C->E
		g.drawLine(225, 430, 225, 235);//C->B
		g.drawArc(185, 465, 55, 60, 115, 315);//C->C
		g.drawArc(85, 125, 485, 355, 190, 60);//C->A

		/*Estado E*/
		g.drawLine(410, 450, 540, 450);//E->G
		g.drawLine(235, 230, 370, 435);//E->B
		g.drawLine(265, 475, 390, 475);//E->C
		g.drawArc(85, 150, 330, 410, 180, 150);//E->A

		/*Estado G*/
		g.drawLine(585, 450, 695, 450);//G->H
		g.drawArc(75, 150, 505, 450, 180, 160);//G->A
		g.drawLine(235, 220, 530, 435);//G->B
		g.drawArc(212, 270, 360, 255, 200, 140);//G->C

		/*Estado H*/
		g.drawArc(65, 90, 670, 570, 180, 160);//H->A
		g.drawLine(250, 220, 690, 435);//H->B
		g.drawArc(215, 270, 500, 295, 200, 140);//H->C

		/*------ETIQUETAS LINEA------*/
		Font miFont2 = new Font("Arial", 1, 16);
		g.setFont(miFont2);
		g.setColor(Color.BLACK);
		
		g.drawString("w", 140, 285);
		g.drawString("e", 140, 380);
		g.drawString("w", 210, 385);
		g.drawString("w", 252, 140);
		g.drawString("e", 295, 184);
		g.drawString("b", 450, 184);
		g.drawString("w", 340, 213);
		g.drawString("e", 365, 245);
		g.drawString("e", 513, 242);
		g.drawString("a", 557, 252);
		g.drawString("e", 177, 488);
		g.drawString("b", 290, 449);
		g.drawString("e", 340, 473);
		g.drawString("w", 361, 420);
		g.drawString("a", 445, 449);
		g.drawString("w", 519, 426);
		g.drawString("y", 610, 445);
		g.drawString("w", 680, 426);
		g.drawString("e", 510, 485);
		g.drawString("e", 670, 493);
		g.drawString("w", 495, 160);
 		
		g.drawString("E", 25, 285);
		g.drawString("E", 182, 187);
		g.drawString("E", 530, 155);
		g.drawString("E", 355, 138);
		g.drawString("E", 170, 457);
	
		g.drawString("E", 365, 516);

		g.drawString("E", 537, 519);

		g.drawString("E", 700, 520);

		g.drawString("Inicio", 13, 434);
		


		/*-----Comenzando a dibujar los estados-----*/
		Graphics2D circulos = (Graphics2D)g;
		circulos.setStroke(new BasicStroke(5.f));
		circulos.setPaint(Color.blue);

		circulos.fillOval(40, 295, 80, 80);//A
		circulos.fillOval(200, 160, 80, 80);//B
		circulos.fillOval(200, 425, 80, 80);//C
		circulos.fillOval(360, 160, 80, 80);//D
		circulos.fillOval(360, 425, 80, 80);//E
		circulos.fillOval(520, 160, 80, 80);//F
		circulos.fillOval(520, 425, 80, 80);//G
		circulos.fillOval(680, 425, 80, 80);//H

		circulos.setStroke(new BasicStroke(3.f));
		circulos.setPaint(Color.black);

		circulos.drawOval(525, 165, 70, 70);//F
		circulos.drawOval(685, 430, 70, 70);//H
		
		/*-----"FLECHAS" LINEAS-----*/
		circulos.setPaint(Color.black);

		circulos.fillOval(35, 338, 13, 13);//A->A
		circulos.fillOval(70, 290, 13, 13);//F->A
		circulos.fillOval(83, 290, 13, 13);//D->A
		circulos.fillOval(96, 295, 13, 13);//B->A
		circulos.fillOval(60, 365, 13, 13);//H->A
		circulos.fillOval(70, 368, 13, 13);//G->A
		circulos.fillOval(81, 365, 13, 13);//E->A
		circulos.fillOval(95, 360, 13, 13);//C->A
		circulos.fillOval(45, 360, 13, 13);// ->A

		circulos.fillOval(195, 195, 13, 13);//A->B
		circulos.fillOval(204, 167, 13, 13);//B->B
		circulos.fillOval(264, 167, 13, 13);//F->B
		circulos.fillOval(273, 208, 13, 13);//D->B
		circulos.fillOval(262, 221, 13, 13);//H->B
		circulos.fillOval(251, 229, 13, 13);//G->B
		circulos.fillOval(235, 233, 13, 13);//E->B
		circulos.fillOval(220, 229, 13, 13);//C->B

		circulos.fillOval(202, 436, 13, 13);//A->C
		circulos.fillOval(231, 499, 13, 13);//C->C
		circulos.fillOval(240, 420, 13, 13);//D->C
		circulos.fillOval(273, 469, 13, 13);//E->C
		circulos.fillOval(258, 427, 13, 13);//F->C
		circulos.fillOval(265, 485, 13, 13);//G->C
		circulos.fillOval(252, 495, 13, 13);//H->C

		circulos.fillOval(357, 180, 13, 13);//B->D

		circulos.fillOval(357, 443, 13, 13);//C->E

		circulos.fillOval(516, 180, 13, 13);//D->F

		circulos.fillOval(515, 443, 13, 13);//E->G
		circulos.fillOval(550, 420, 13, 13);//F->G

		circulos.fillOval(675, 443, 13, 13);//G->H


		/*-----ETIQUETAS ESTADOS-----*/
		Font miFont = new Font("Arial", 1, 22);
		g.setFont(miFont);
		g.setColor(Color.RED);

		g.drawString("A", 80, 335);
		g.drawString("B", 240, 200);
		g.drawString("C", 240, 465);
		g.drawString("D", 400, 200);
		g.drawString("E", 400, 465);
		g.drawString("F", 560, 200);
		g.drawString("G", 560, 465);
		g.drawString("H", 720, 465);
		
	}

	public static void main(String args[]){
	
		new AFD();
		
	}

}