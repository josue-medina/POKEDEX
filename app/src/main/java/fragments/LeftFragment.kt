package fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basicnavigation.databinding.FragmentLeftBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONObject

private lateinit var database:DatabaseReference
class LeftFragment : Fragment() {
    private lateinit var binding: FragmentLeftBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeftBinding.inflate(inflater,container,false)
        val myDB= FirebaseDatabase.getInstance()
        database = myDB.reference
        database.child("usuarios").child("001").get().addOnSuccessListener { record->
            val json= JSONObject(record.value.toString())
            /*
            binding.nombre.setText(json.getString("nombre").toString())
            binding.nickname.setText(json.getString("nickname").toString())
            binding.nivel.setText(json.getString("nivel").toString())
            binding.pokemons.setText(json.getString("numeropoke").toString())

             */
        }
        return binding.root
    }
}