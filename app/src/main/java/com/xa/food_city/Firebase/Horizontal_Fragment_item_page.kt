package com.xa.food_city.Firebase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.xa.food_city.Fragments.MainFragment
import com.xa.food_city.R

class Horizontal_Fragment_item_page : Fragment() {

    lateinit var userList: ArrayList<HorizontalDataUser>
    lateinit var ref: DatabaseReference
    private var storageRef: StorageReference? = null
    private var mImageUri: Uri? = null
    private var PICK_IMAGE_REQUEST = 1
    private var mUploadTask: StorageTask<*>? = null

    //FIND FROM UI
    lateinit var products_Spinner: Spinner
    lateinit var currency_Spinner: Spinner
    lateinit var add_product_button: Button
    lateinit var product_name: EditText
    lateinit var product_cost: EditText
    lateinit var product_info: EditText
    lateinit var imageViewItem_: ImageView
    lateinit var select_image_btn: Button

    //get
    lateinit var spinner2: String
    lateinit var spinner1: String

    //spinner data and cash type...!!!
    private val product_type = arrayOf(
        "Mevalar",
        "Sabzavotlar",
        "Non maxsulo..",
        "Quruq meva..",
        "Gosht maxs..",
        "Sut maxsul..",
        "Don maxsul..",
        "Tort maxsul..",
        "Tayor maxsul",

        )
    val kash_type = arrayOf("sum", "$")
    //
    //
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_horizontal_item_data, container, false)
        userList = arrayListOf()

        //find UI
        product_name = view.findViewById(R.id.a)
        product_cost = view.findViewById(R.id.b)
        product_info = view.findViewById(R.id.c)

        select_image_btn = view.findViewById(R.id.select_image_btn)
        imageViewItem_ = view.findViewById(R.id.image_item_selected)


        //find
        add_product_button = view.findViewById(R.id.add_btn_favorit)

        product_name.addTextChangedListener(loginTextWather)
        product_cost.addTextChangedListener(loginTextWather)
        product_info.addTextChangedListener(loginTextWather)


        //storage for image recycleview
        storageRef = FirebaseStorage.getInstance().getReference("Users")
        ref = FirebaseDatabase.getInstance().getReference("Users")

        select_image_btn.setOnClickListener { openFileChoose() }
        add_product_button.setOnClickListener {
            if (mUploadTask != null && mUploadTask!!.isInProgress) {
                Toast.makeText(context, "still progress", Toast.LENGTH_SHORT).show()
            }
        }
        //find spinner  and start
        products_Spinner = view.findViewById<Spinner>(R.id.spinner)
        currency_Spinner = view.findViewById<Spinner>(R.id.spinner2)
        val arrayAdapter = ArrayAdapter<String>(
            this@Horizontal_Fragment_item_page.requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, product_type
        )
        products_Spinner.adapter = arrayAdapter
        products_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                spinner1 = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        //spinner 2 type
        val arrayAdapter2 = ArrayAdapter<String>(
            this@Horizontal_Fragment_item_page.requireContext(),
            androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
            kash_type
        )
        currency_Spinner.adapter = arrayAdapter2
        currency_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {

                spinner2 = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
        //end......

        add_product_button.setOnClickListener {
            saveProduct()
//            uploadFile()
            Toast.makeText(context, "Product added seccessfully", Toast.LENGTH_SHORT).show()
            main()
        }



        return view


    }

    private fun main() {
        val trans = fragmentManager?.beginTransaction()?.replace(R.id.frameLayout,MainFragment())
        trans?.commit()
    }


    private fun openFileChoose() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, PICK_IMAGE_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST) {
            mImageUri = data!!.data
            imageViewItem_.setImageURI(mImageUri)
        } else {
            Toast.makeText(context, "else", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun getFileExtension(uri: Uri): String? {
//        val cr = cont
//        val mime = MimeTypeMap.getSingleton()
//        return mime.getExtensionFromMimeType(cr.getType(uri))
//    }

    private val loginTextWather = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val user_name = product_name.text.toString().trim()
            val user_vally = product_cost.text.toString().trim()
            val info_info = product_info.text.toString().trim()

            add_product_button.isEnabled =
                user_name.isNotEmpty() && user_vally.isNotEmpty() && info_info.isNotEmpty()
            return
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

    private fun uploadFile() {

        if (mImageUri != null) {
            val fileReferece =
                storageRef!!.child((System.currentTimeMillis().toString()+"."+mImageUri) )    //getFileExtension(mImageUri!!)
                    mUploadTask = fileReferece.putFile(mImageUri!!)
                     .addOnSuccessListener {
                         //toast
                     }
        } else {
            Toast.makeText(context, "please select image", Toast.LENGTH_SHORT).show()

        }
    }


    private fun saveProduct() {
        val name = product_name.text.toString().trim()
        val cost = product_cost.text.toString().trim()
        val info1 = product_info.text.toString().trim()
        val cost_Spinner = spinner2
        val product_type = spinner1
        val imageView_ =mImageUri.toString()   //error image

        if (name.isEmpty()) {
            return
        }
        val userId = ref.push().key
        val user = HorizontalDataUser(
            userId,
            name,
            cost,
            product_type,
            cost_Spinner,
            info1,
            imageView_
        )
        ref.child(userId!!).setValue(user).addOnCompleteListener { }

    }

}