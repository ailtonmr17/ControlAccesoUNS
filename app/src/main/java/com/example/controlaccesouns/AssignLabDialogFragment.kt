import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.controlaccesouns.R

class AssignLabDialogFragment(private val onAssign: (String, String, String, String, String) -> Unit) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_assign_lab, container, false)

        val editLabName: EditText = view.findViewById(R.id.editLabName)
        val editDocente: EditText = view.findViewById(R.id.editDocente)
        val editCurso: EditText = view.findViewById(R.id.editCurso)
        val editStartTime: EditText = view.findViewById(R.id.editStartTime)
        val editEndTime: EditText = view.findViewById(R.id.editEndTime)
        val btnSave: Button = view.findViewById(R.id.btnSaveAssign)
        val btnCancel: Button = view.findViewById(R.id.btnCancelAssign)

        btnSave.setOnClickListener {
            val labName = editLabName.text.toString().trim()
            val docente = editDocente.text.toString().trim()
            val curso = editCurso.text.toString().trim()
            val startTime = editStartTime.text.toString().trim()
            val endTime = editEndTime.text.toString().trim()

            if (labName.isEmpty() || docente.isEmpty() || curso.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                onAssign(labName, docente, curso, startTime, endTime)
                dismiss()
            }
        }

        btnCancel.setOnClickListener {
            dismiss()
        }

        return view
    }
}
