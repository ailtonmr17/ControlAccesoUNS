import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R

data class ReportItem(val lab: String, val docente: String, val curso: String, val fecha: String, val horas: String)

class ReportPreviewAdapter(private val reportItems: List<ReportItem>) :
    RecyclerView.Adapter<ReportPreviewAdapter.ReportViewHolder>() {

    class ReportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lab: TextView = itemView.findViewById(R.id.textLab)
        val docente: TextView = itemView.findViewById(R.id.textDocente)
        val curso: TextView = itemView.findViewById(R.id.textCurso)
        val fecha: TextView = itemView.findViewById(R.id.textFecha)
        val horas: TextView = itemView.findViewById(R.id.textHoras)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_report_preview, parent, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val item = reportItems[position]
        holder.lab.text = item.lab
        holder.docente.text = item.docente
        holder.curso.text = item.curso
        holder.fecha.text = item.fecha
        holder.horas.text = item.horas
    }

    override fun getItemCount(): Int = reportItems.size
}
