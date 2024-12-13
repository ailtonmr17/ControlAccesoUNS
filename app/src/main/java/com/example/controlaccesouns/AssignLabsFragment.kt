import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R
import com.google.android.material.button.MaterialButton

class AssignLabsFragment : Fragment() {

    private lateinit var recyclerViewLabs: RecyclerView
    private lateinit var btnOpenAssignForm: MaterialButton
    private val labs = mutableListOf(
        Lab("Laboratorio 301", "Disponible"),
        Lab("Laboratorio 302", "Ocupado"),
        Lab("Laboratorio 303", "Disponible")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_assign_labs, container, false)

        // Configurar RecyclerView
        recyclerViewLabs = view.findViewById(R.id.recyclerViewLabs)
        btnOpenAssignForm = view.findViewById(R.id.btnOpenAssignForm)

        recyclerViewLabs.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewLabs.adapter = LabsAdapter(labs)

        // Abrir formulario de asignación
        btnOpenAssignForm.setOnClickListener {
            val dialog = AssignLabDialogFragment { labName, docente, curso, startTime, endTime ->
                Toast.makeText(requireContext(), "Asignado: $labName a $docente ($curso)", Toast.LENGTH_LONG).show()
                // Aquí puedes guardar los datos en tu base de datos o lista
            }
            dialog.show(parentFragmentManager, "AssignLabDialogFragment")
        }

        return view
    }
}
