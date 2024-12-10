package adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_app.R
import de.hdodenhof.circleimageview.CircleImageView

class FruitsAdapter(
    val context: Context,
    val imageList: ArrayList<Int>,
    val fruitsList: ArrayList<String>,
    val fruitsDesc: ArrayList<String>
) : RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>() {
    class FruitsViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
            var image: CircleImageView = itemView.findViewById(R.id.profile_image)
            var title: TextView = itemView.findViewById(R.id.lblFruitName)
            var desc: TextView = itemView.findViewById(R.id.lblFruitDescription)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}