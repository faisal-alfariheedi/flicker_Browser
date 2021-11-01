package com.example.flicker_browser

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flicker_browser.network.APIClient
import com.example.flicker_browser.network.APIInterface
import com.example.flicker_browser.network.feed
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class main : Fragment() {
    lateinit var rv: RecyclerView
    lateinit var ser: Button
    lateinit var ed: EditText
    lateinit var spn: Spinner
    //    var imgarr= arrayListOf<image>()
    var sel=0
    var sell=arrayListOf(10,50,100)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v= inflater.inflate(R.layout.fragment_main, container, false)
        setHasOptionsMenu(true)
        init(v)
        if (spn != null) {
            val adapter = ArrayAdapter(v.context, android.R.layout.simple_spinner_item,sell )
            spn.adapter = adapter
            spn.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    sel = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    sel=0
                }
            }
        }
        ser.setOnClickListener{
            search(v)
        }

        return v
    }

    fun init(v: View) {
        ser=v.findViewById(R.id.serch)
        ed=v.findViewById(R.id.ed)
        spn=v.findViewById(R.id.spn)
        rv=v.findViewById(R.id.rvm)
        image.imgarr.clear()
        rv.adapter=RVAdapter(image.imgarr,this)
        rv.layoutManager= GridLayoutManager(v.context,2)
//        rv.layoutManager= LinearLayoutManager(this)
    }
    fun search(v: View) {
        val apif = APIClient().getClient()?.create(APIInterface::class.java)
        image.imgarr.clear()
        CoroutineScope(Dispatchers.IO).launch {
            if (apif != null) {
                apif.getdat("flickr.photos.search","33a9d39f0edb9d9c75cdf2a50fa983cd",ed.text.toString(),sell[sel].toString(),"json",)
                    .enqueue(object : Callback<feed> {
                        override fun onResponse(call: Call<feed>, response: Response<feed>
                        ) {
//                            Log.d("responimg", "onResponse: ${response}")
//                            Log.d("responimg", "onResponse: ${response.body()}")
                            var a = response.body()
                            for (i in a!!.photos?.photo!!) {

                                image.imgarr.add(
                                    image(i.title, "https://farm${i.farm}.staticflickr.com/${i.server}/${i.id}_${i.secret}.jpg",
                                        ed.text.toString(),i.id!!)
                                )

                            }
                            rv.adapter?.notifyDataSetChanged()

                        }

                        override fun onFailure(call: Call<feed>, t: Throwable) {
                            Log.d("responimg", "onResponse: ${t}")
                            Toast.makeText(v.context, t.message, Toast.LENGTH_SHORT).show();
                        }

                    })
            }
        }
    }
    /////////////////////menu////////////////////////////


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

    }

    override fun onPrepareOptionsMenu(menu: Menu) {

        val item1 = menu!!.getItem(0)
        item1.setTitle("switch to favorite")


        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m1 -> {
                //switchero to fav
                Navigation.findNavController(requireView()).navigate(R.id.action_main_to_favv)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}