package com.sportoverfifty.mypresents


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UebersichtGeschenkeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class UebersichtGeschenkeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var mListeView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mView = inflater?.inflate(R.layout.fragment_uebersicht_geschenke,container,false)
        mListeView = mView?.findViewById<ListView>(R.id.listUebersichtGeschenke)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listeneintrag = ArrayList<GiftObject>()
//GiftObject (val id: Int, val name: String, val gekauft: Boolean, val shop: String, val beschreibung: String, val bild : Drawable, val geschenkFuer: String)
        listeneintrag.add(GiftObject(id =1, name ="Taschenlampe", gekauft =false, shop ="Alternate", beschreibung = "Lampe für's Wandern", bild = ContextCompat.getDrawable(context!!, R.drawable.shopping), geschenkFuer ="Marius"))
        listeneintrag.add(GiftObject(id =2, name ="Flasche", gekauft =false, shop ="Globetrotter", beschreibung = "Lampe für's Wandern", bild = ContextCompat.getDrawable(context!!, R.drawable.shopping), geschenkFuer ="Marius"))
        listeneintrag.add(GiftObject(id =3, name ="MTB", gekauft =false, shop ="Fahrrad.de", beschreibung = "Lampe für's Wandern", bild = ContextCompat.getDrawable(context!!, R.drawable.shopping), geschenkFuer ="Marius"))
        listeneintrag.add(GiftObject(id =4, name ="Surfboard", gekauft =false, shop ="Surfdome", beschreibung = "Lampe für's Wandern", bild = ContextCompat.getDrawable(context!!, R.drawable.shopping), geschenkFuer ="Marius"))
        mListeView?.adapter = ShoppingListAdapter(context!!, listeneintrag)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UebersichtGeschenkeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UebersichtGeschenkeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
