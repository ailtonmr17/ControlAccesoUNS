import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R

data class Lab(val name: String, val status: String)

class LabsAdapter(private val labs: List<Lab>) :
    RecyclerView.Adapter<LabsAdapter.LabViewHolder>() {

    class LabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labName: TextView = itemView.findViewById(R.id.textLabName)
        val labStatus: TextView = itemView.findViewById(R.id.textLabStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lab, parent, false)
        return LabViewHolder(view)
    }

    override fun onBindViewHolder(holder: LabViewHolder, position: Int) {
        val lab = labs[position]
        holder.labName.text = lab.name
        holder.labStatus.text = lab.status
        holder.labStatus.setTextColor(
            if (lab.status == "Disponible")
                holder.itemView.context.getColor(android.R.color.holo_green_dark)
            else
                holder.itemView.context.getColor(android.R.color.holo_red_dark)
        )
    }

    override fun getItemCount(): Int = labs.size
}
