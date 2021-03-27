package marco.umg.com.proyectochat.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import marco.umg.com.proyectochat.Entidades.Firebase2.Mensaje;
import marco.umg.com.proyectochat.Entidades.Firebase2.MensajeEnviar;
import marco.umg.com.proyectochat.Entidades.Firebase2.MensajeRecibir;
import marco.umg.com.proyectochat.Entidades.Firebase2.LMensaje2;
import marco.umg.com.proyectochat.Entidades.Logica.LMensaje;
import marco.umg.com.proyectochat.Holder.MensajeriaHolder;
import marco.umg.com.proyectochat.Persistencia.UsuarioDAO;
import marco.umg.com.proyectochat.R;

/**
 * Created by user on 04/09/2017. 04
 */

public class AdapterMensajes2 extends RecyclerView.Adapter<HolderMensaje2>  {

    private List<MensajeRecibir> listMensaje = new ArrayList<>();
    private Context c;

    public AdapterMensajes2(Context c) {
        this.c = c;
    }

    public void addMensaje(MensajeRecibir m){
        listMensaje.add(m);
        notifyItemInserted(listMensaje.size());
    }


    @Override
    public HolderMensaje2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType==1){
            view = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes_receptor,parent,false);
        }else{
            view = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes_emisor,parent,false);
        }
        return new HolderMensaje2(view);
    }

  //  @Override
   // public HolderMensaje2 onCreateViewHolder(ViewGroup parent, int viewType) {
    //    View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes2,parent,false);
    //    return new HolderMensaje2(v);
   // }

    @Override
    public void onBindViewHolder(HolderMensaje2 holder, int position) {
        holder.getNombre().setText(listMensaje.get(position).getNombre());
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());
        if(listMensaje.get(position).getType_mensaje().equals("2")){
            holder.getFotoMensaje().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.VISIBLE);
            Glide.with(c).load(listMensaje.get(position).getUrlFoto()).into(holder.getFotoMensaje());
        }else if(listMensaje.get(position).getType_mensaje().equals("1")){
            holder.getFotoMensaje().setVisibility(View.GONE);
            holder.getMensaje().setVisibility(View.VISIBLE);
        }
        if(listMensaje.get(position).getFotoPerfil().isEmpty()){
            holder.getFotoMensajePerfil().setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(c).load(listMensaje.get(position).getFotoPerfil()).into(holder.getFotoMensajePerfil());
        }
        Long codigoHora = listMensaje.get(position).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");//a pm o am
        holder.getHora().setText(sdf.format(d));
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }


}
