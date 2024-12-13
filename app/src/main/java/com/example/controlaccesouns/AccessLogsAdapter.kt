import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R

class AccessLogsAdapter(private val accessLogs: List<AccessLog>) :
    RecyclerView.Adapter<AccessLogsAdapter.AccessLogViewHolder>() {

    class AccessLogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.textId)
        val docente: TextView = itemView.findViewById(R.id.textDocente)
        val laboratorio: TextView = itemView.findViewById(R.id.textLaboratorio)
        val curso: TextView = itemView.findViewById(R.id.textCurso)
        val fecha: TextView = itemView.findViewById(R.id.textFecha)
        val horaEntrada: TextView = itemView.findViewById(R.id.textHoraEntrada)
        val horaSalida: TextView = itemView.findViewById(R.id.textHoraSalida)
        val estado: TextView = itemView.findViewById(R.id.textEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccessLogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_access_log, parent, false)
        return AccessLogViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccessLogViewHolder, position: Int) {
        val log = accessLogs[position]
        holder.id.text = log.id
        holder.docente.text = log.docente
        holder.laboratorio.text = log.laboratorio
        holder.curso.text = log.curso
        holder.fecha.text = log.fecha
        holder.horaEntrada.text = log.horaEntrada
        holder.horaSalida.text = log.horaSalida
        holder.estado.text = log.estado

        // Cambia el color del estado según su valor
        when (log.estado) {
            "Completado" -> holder.estado.setTextColor(holder.itemView.context.getColor(android.R.color.holo_green_dark))
            "En curso" -> holder.estado.setTextColor(holder.itemView.context.getColor(android.R.color.holo_orange_dark))
            else -> holder.estado.setTextColor(holder.itemView.context.getColor(android.R.color.darker_gray))
        }
    }

    override fun getItemCount(): Int = accessLogs.size
}
