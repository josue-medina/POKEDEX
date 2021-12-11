package fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.basicnavigation.database.User
import com.example.basicnavigation.databinding.FragmentRightBinding


class RightFragment : Fragment() {
    private lateinit var queue: RequestQueue
    private lateinit var binding: FragmentRightBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentRightBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etPokemonName = binding.etPokemonToSearchFor
        val destinationViewModel: DestinationViewModel by viewModels()
        queue = Volley.newRequestQueue(context)
        binding.btnSearch.setOnClickListener(){
            getPokemon(etPokemonName.text.toString())
            etPokemonName.text.clear()
        }

        binding.guadamesta.setOnClickListener {
            val destination = RightFragmentDirections.actionRightFragmentToDestinationFragment()
            NavHostFragment.findNavController(this).navigate(destination)
            destinationViewModel.save(
                User(
                    binding.idpoke.text.toString().toInt(),
                    binding.tvName.text.toString(),
                    binding.tvTipo.text.toString(),
                    binding.tvHp.text.toString(),
                    binding.tvAttack.text.toString(),
                    binding.tvSpecial.text.toString(),
                    binding.tvDeffense.text.toString(),
                    binding.tvDs.text.toString(),
                    binding.tvSpeed.text.toString(),
                    binding.tvWeight.text.toString()
                )
            )
        }
    }

    fun getPokemon(pokemonName: String){
        val url ="https://pokeapi.co/api/v2/pokemon/${pokemonName}"
        val jsonRequest = JsonObjectRequest(url, { response->
            binding.idpoke.setText(response.getString("id"))
            binding.tvName.setText(response.getString("name"))
            binding.tvTipo.setText(response.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name"))
            binding.tvHp.setText(response.getJSONArray("stats").getJSONObject(0).getString("base_stat"))
            binding.tvAttack.setText(response.getJSONArray("stats").getJSONObject(1).getString("base_stat"))
            binding.tvSpecial.setText(response.getJSONArray("stats").getJSONObject(3).getString("base_stat"))
            binding.tvDeffense.setText(response.getJSONArray("stats").getJSONObject(2).getString("base_stat"))
            binding.tvDs.setText(response.getJSONArray("stats").getJSONObject(4).getString("base_stat"))
            binding.tvSpeed.setText(response.getJSONArray("stats").getJSONObject(5).getString("base_stat"))
            binding.tvWeight.setText(response.getString("weight"))
            //val infoString = "Nombre: ${name.replaceFirstChar { it.uppercase() }} #: $id \nTipo: $tipo \nPuntos de Salud: $hp \nAtaque: $attack\nAtaque especial: $special \nDefensa: $deffense \nDefensa especial:  $deffense_special \nVelocidad: $speed \nPeso: $weight"
             //   binding.tvPokemonInfo.setText(infoString)
            },
            { errorMessage->
                binding.tvPokemonInfo.setText("404 Pokemon Not found")
                Log.d("JSONResponse","Error: $errorMessage")
            }
        )
        queue.add(jsonRequest)
    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll("stopped")
    }

}