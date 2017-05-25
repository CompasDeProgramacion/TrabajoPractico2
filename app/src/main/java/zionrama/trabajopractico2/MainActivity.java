package zionrama.trabajopractico2;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

   ImageButton[] ArrayBotones = new ImageButton[9];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //Bloqueo los botones hasta que se ingrese el nombre
        ArrayBotones[0] = (ImageButton) findViewById(R.id.Boton1);
        ArrayBotones[1] = (ImageButton) findViewById(R.id.Boton2);
        ArrayBotones[2] = (ImageButton) findViewById(R.id.Boton3);
        ArrayBotones[3] = (ImageButton) findViewById(R.id.Boton4);
        ArrayBotones[4] = (ImageButton) findViewById(R.id.Boton5);
        ArrayBotones[5] = (ImageButton) findViewById(R.id.Boton6);
        ArrayBotones[6] = (ImageButton) findViewById(R.id.Boton7);
        ArrayBotones[7] = (ImageButton) findViewById(R.id.Boton8);
        ArrayBotones[8] = (ImageButton) findViewById(R.id.Boton9);
        for (int i = 0; i <= 8; i++)
        {
            ArrayBotones[i].setEnabled(false);
        }
    }


    public void NombreIngresado(View view)
    {
        EditText TextoNombre = (EditText) findViewById(R.id.TextoNombre);
        String StringNombre = TextoNombre.getText().toString();
        if (StringNombre.matches(""))
        {
            Toast MensajeError;
            MensajeError = Toast.makeText(this, "Ingresá un nombre para comenzar lo dice ahí papu", Toast.LENGTH_SHORT);
            MensajeError.show();
        }
        else
        {
            for (int i = 0; i <= 8; i++)
            {
                ArrayBotones[i].setEnabled(true);
            }
            AsignarImagen();
            Toast Bienvenida;
            Bienvenida = Toast.makeText(this, "Bienvenido/a " + StringNombre, Toast.LENGTH_SHORT);
            Bienvenida.show();
        }
    }

    void AsignarImagen() //Funciona hiper perfecto
    {
        for (int i = 0; i <= 8; i++)
        {
            switch (i)
            {
                case 0:
                    AsignarImagenABoton(R.id.Boton1);
                    break;
                case 1:
                    AsignarImagenABoton(R.id.Boton2);
                    break;
                case 2:
                    AsignarImagenABoton(R.id.Boton3);
                    break;
                case 3:
                    AsignarImagenABoton(R.id.Boton4);
                    break;
                case 4:
                    AsignarImagenABoton(R.id.Boton5);
                    break;
                case 5:
                    AsignarImagenABoton(R.id.Boton6);
                    break;
                case 6:
                    AsignarImagenABoton(R.id.Boton7);
                    break;
                case 7:
                    AsignarImagenABoton(R.id.Boton8);
                    break;
                case 8:
                    AsignarImagenABoton(R.id.Boton9);
                    break;
            }
        }
    }

    int AsignarImagenABoton(int IdBotonAAsignar) //Esto funciona
    {
        Random GeneradorDeAzar;
        GeneradorDeAzar = new Random();

        int NumeroImagen;
        NumeroImagen = GeneradorDeAzar.nextInt(2);

        ImageButton BotonACambiar = (ImageButton) findViewById(IdBotonAAsignar);

        if (NumeroImagen == 0)
        {
            BotonACambiar.setImageResource(R.drawable.rojo);
        }
        else
        {
            BotonACambiar.setImageResource(R.drawable.verde);
        }
        return NumeroImagen;
    }

    public void Boton (View VistaBoton) //Recontra funciona
    {
       ImageButton BotonPresionado = (ImageButton)VistaBoton;
        String StrBotonPresionado = BotonPresionado.getTag().toString();
        int IntBotonPresionado = Integer.parseInt(StrBotonPresionado);
        switch (IntBotonPresionado)
            {
                case (0):
                    InversionBotones(0, 1, 3, 4);
                    ChequeoSiGane();
                    break;
                case (1):
                    InversionBotones(1, 0, 2, 4);
                    ChequeoSiGane();
                    break;
                case (2):
                    InversionBotones(2, 1, 4, 5);
                    ChequeoSiGane();
                    break;
                case (3):
                    InversionBotones(3, 0, 4, 6);
                    ChequeoSiGane();
                    break;
                case (4):
                    InversionBotones(4, 1, 3, 5);
                    ChequeoSiGane();
                    break;
                case (5):
                    InversionBotones(5, 2, 4, 8);
                    ChequeoSiGane();
                    break;
                case (6):
                    InversionBotones(6, 3, 4, 7);
                    ChequeoSiGane();
                    break;
                case (7):
                    InversionBotones(7, 4, 6, 8);
                    ChequeoSiGane();
                    break;
                case (8):
                    InversionBotones(8, 4, 5, 7);
                    ChequeoSiGane();
                    break;
            }
    }


    public void InversionBotones(int BtnApretado, int BtnACambiarA, int BtnACambiarB, int BtnACambiarC) //Funca baby
    {
        Drawable.ConstantState CodigoImagenRojo = ContextCompat.getDrawable(this, R.drawable.rojo).getConstantState();
        ImageButton[] ArrayBotonesAux = new ImageButton[4];
        ArrayBotonesAux[0] = ArrayBotones[BtnApretado];
        ArrayBotonesAux[1] = ArrayBotones[BtnACambiarA];
        ArrayBotonesAux[2] = ArrayBotones[BtnACambiarB];
        ArrayBotonesAux[3] = ArrayBotones[BtnACambiarC];
        for(int i=0; i<=4; i++)
        {
            Drawable.ConstantState CodigoImagenBotonApretado = ArrayBotones[i].getDrawable().getConstantState();
            if (CodigoImagenBotonApretado == CodigoImagenRojo)
            {
                ArrayBotonesAux[i].setImageResource(R.drawable.verde);
            }
            else
            {
                ArrayBotonesAux[i].setImageResource(R.drawable.rojo);
            }
        }

        if (BtnApretado == 4)
        {
            for(int i=0; i<=4; i++)
            {
                Drawable.ConstantState CodigoImagenBotonApretado = ArrayBotones[i].getDrawable().getConstantState();
                if (CodigoImagenBotonApretado == CodigoImagenRojo)
                {
                    ArrayBotonesAux[i].setImageResource(R.drawable.verde);
                }
                else
                {
                    ArrayBotonesAux[i].setImageResource(R.drawable.rojo);
                }
            }
        }

    }

    public void ChequeoSiGane() //EN CONSTRUCCIÓN
    {
        Drawable.ConstantState CodigoImagenRojo = ContextCompat.getDrawable(this, R.drawable.rojo).getConstantState();
        Drawable.ConstantState CodigoImagenVerde = ContextCompat.getDrawable(this, R.drawable.verde).getConstantState();
        int i = 0;
        switch (i)
        {
           case 0:
               int ContadorGanadorRojo = 0;
               for (int JUJU=0; JUJU <=8; JUJU++)
               {
                   Drawable.ConstantState CodigoBoton = ArrayBotones[JUJU].getDrawable().getConstantState();
                   if (CodigoBoton == CodigoImagenRojo)
                   {
                       ContadorGanadorRojo++;
                       if(ContadorGanadorRojo == 8)
                       {
                           Toast MensajeGanador = Toast.makeText(this, "¡Felicidades, ganaste!", Toast.LENGTH_SHORT);
                           MensajeGanador.show();
                           break;
                       }
                   }
                   else
                   {
                       i++;
                       break;
                   }
                }
            case 1:
                int ContadorGanadorVerde = 0;
                for (int JUJU=0; JUJU <=8; JUJU++)
                {
                    Drawable.ConstantState CodigoBoton = ArrayBotones[JUJU].getDrawable().getConstantState();
                    if (CodigoBoton == CodigoImagenVerde)
                    {
                        ContadorGanadorVerde++;
                        if(ContadorGanadorVerde == 8)
                        {
                            Toast MensajeGanador = Toast.makeText(this, "¡Felicidades, ganaste!", Toast.LENGTH_SHORT);
                            MensajeGanador.show();
                            break;
                        }
                    }
                    else
                    {
                        i++;
                        break;
                    }
                }
        }
    }

    @Override
    public void onStart()
    {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://zionrama.trabajopractico2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop()
    {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://zionrama.trabajopractico2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
