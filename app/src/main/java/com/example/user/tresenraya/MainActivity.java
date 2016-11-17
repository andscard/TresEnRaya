package com.example.user.tresenraya;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends Activity {
    Button botones[][];
    Button boton_limpiar;
    Button boton_salir;
    TextView textView_turno;
    TextView textView_puntosX;
    TextView textView_puntosO;
    TextView textView_ganador;
    String turno = "X";
    Boolean ganador=false;
    int puntosX=0;
    int puntosO=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_ganador = (TextView) findViewById(R.id.tv_ganador);
        textView_turno = (TextView) findViewById(R.id.tv_turno);
        textView_puntosX = (TextView) findViewById(R.id.tv_puntosX);
        textView_puntosO = (TextView) findViewById(R.id.tv_puntosO);
        boton_limpiar = (Button) findViewById(R.id.bt_limpiar);
        boton_salir= (Button) findViewById(R.id.bt_salir);

        //limpiarJuego();


    }


    public void llenarMatrizBotones(){
        botones[0][0]= (Button)findViewById(R.id.bt_11);
        botones[0][1]= (Button)findViewById(R.id.bt_12);
        botones[0][2]= (Button)findViewById(R.id.bt_13);
        botones[1][0]= (Button)findViewById(R.id.bt_21);
        botones[1][1]= (Button)findViewById(R.id.bt_22);
        botones[1][2]= (Button)findViewById(R.id.bt_23);
        botones[2][0]= (Button)findViewById(R.id.bt_31);
        botones[2][1]= (Button)findViewById(R.id.bt_32);
        botones[2][2]= (Button)findViewById(R.id.bt_33);
    }

    public void limpiarJuego(){
        for(int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                botones[i][j].setText(" ");
            }
        }
    }
    public void presionarBoton(View view){
        Button button = (Button) view;
        button.setText(turno);
        aumentarPuntos();
        button.setEnabled(false);
        muestraGanador();
        cambiarTurno();
    }


    public void cambiarTurno(){
        if(turno == "X"){
            turno="O";
        }
        else{
            turno="X";
        }


    }

    public void aumentarPuntos(){
        if (turno=="X"){
            puntosX=puntosX+1;
            textView_puntosX.setText(String.valueOf(puntosX));
        }else{
            puntosO=puntosO+1;
            textView_puntosO.setText(String.valueOf(puntosO));
        }
    }

    public void muestraGanador(){

        if (verificaGanador()==true){
            if(turno=="X"){textView_ganador.setText("Ha ganado  X");}

            if (turno=="O"){textView_ganador.setText("Ha ganado  O");}
        }else{
            return;
        }
    }

    public boolean verificaGanador(){
        if((botones[0][0].getText()==turno) && (botones[0][1].getText()==turno) && (botones[0][2].getText()==turno)){
            return true;
        }
        if((botones[1][0].getText()==turno) && (botones[1][1].getText()==turno) && (botones[1][2].getText()==turno)){
            return true;
        }
        if((botones[2][0].getText()==turno) && (botones[2][1].getText()==turno) && (botones[2][2].getText()==turno)){
            return true;
        }
        if((botones[0][0].getText()==turno) && (botones[1][0].getText()==turno) && (botones[2][0].getText()==turno)){
            return true;
        }
        if((botones[0][1].getText()==turno) && (botones[1][1].getText()==turno) && (botones[2][1].getText()==turno)){
            return true;
        }
        if((botones[0][2].getText()==turno) && (botones[1][2].getText()==turno) && (botones[2][2].getText()==turno)){
            return true;
        }
        if((botones[0][0].getText()==turno) && (botones[1][1].getText()==turno) && (botones[2][2].getText()==turno)){
            return true;
        }
        if((botones[0][2].getText()==turno) && (botones[1][1].getText()==turno) && (botones[2][0].getText()==turno)){
            return true;
        }
        return false;
    }

    public void salirJuego(View v) {
        finish();}
}
