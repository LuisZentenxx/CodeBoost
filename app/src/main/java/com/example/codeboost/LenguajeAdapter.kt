import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codeboost.Lenguaje
import com.example.codeboost.R

/* Este código se encarga de organizar y mostrar una lista de elementos de tipo Lenguaje en un RecyclerView,
    asignando la información correspondiente a cada celda del RecyclerView para que se muestre al usuario.*/
class LanguageAdapter(private val languageList: List<Lenguaje>) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    // : Se crea una nueva vista inflando el diseño desde el archivo XML lenguaje_item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lenguaje_item, parent, false)
        return LanguageViewHolder(view) // Se devuelve una nueva instancia de LanguageViewHolder.
    }

    // Establece los datos en la vista de cada celda según la posición en la lista.
    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = languageList[position] // Se obtiene el objeto de Lenguaje desde la lista.
        holder.bind(language) // Se llama al método bind para establecer los datos en la vista.
    }

    // Devuelve la cantidad total de elementos en la lista.
    override fun getItemCount(): Int {
        return languageList.size
    }

    // Clase interna que representa la vista de cada celda del RecyclerView.
    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referencias a los elementos de la vista de la celda.
        private val languageIcon: ImageView = itemView.findViewById(R.id.languageIcon)
        private val languageName: TextView = itemView.findViewById(R.id.languageName)

        // Método para establecer los datos de un objeto de Lenguaje en la vista.
        fun bind(language: Lenguaje) {
            languageIcon.setImageResource(language.iconResource) // Se establece la imagen del Lenguaje.
            languageName.text = language.name // Se establece el nombre del Lenguaje.
        }
    }
}
