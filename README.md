# UI Elements

**TextView**: muestra texto al usuario

```xml<TextView	android:id="@+id/text_id"	android:layout_width="wrap_content"	android:layout_height="wrap_content"	android:text="hello_world"	android:textColor="@android:color/holo_blue_dark"	android:textSize="20sp"/>
```
**EditText**: Permite al usuario editar un campo de texto

```xml<EditText	android:id="@+id/editText"	android:layout_width="wrap_content"	android:layout_height="wrap_content"	android:hint="Name"	android:inputType="textPersonName"/>
```
**Button**: control con texto o imagen que realiza una acción cuando el usuario lo presiona```xml<Button	android:layout_width="wrap_content"	android:layout_height="wrap_content"	android:text="Enviar" />
```

## Layouts

Si queremos combinar varios elementos de tipo vista tendremos que utilizar un objeto de tipo Layout.
Es un contenedor que alberga varias vistas y controla su posición.Hay que destacar que un Layout puede tener varios contenedores dentro y que es un descendientede la clase ViewGroup.
La siguiente lista describe los Layout más utilizados en Android:
* **`LinearLayout`**: Dispone los elementos en una fila o en una columna.* **`TableLayout`**: Distribuye los elementos de forma tabular.* **`RelativeLayout`**: Dispone los elementos en relación a otro o al padre.* **`FrameLayout`**: Permite el cambio dinámico de los elementos que contiene.* **`ConstraintLayout`**: Versión mejorada de `RelativeLayout`, que permite una edición visual desde el editor y trabajar con porcentajes.

### `LinearLayout`

**LinearLayout**: Alinea todos los campos secundarios en una única dirección, de manera vertical u horizontal. Puedes especificar la dirección del diseño con el atributo `android:orientation`

<img src="imgs/linear-layout.png" alt="linear layout">

### `RelativeLayout`

### `ConstraintLayout`

## Scrolls



## Vinculación de vista

1. Kotlin extensions (actualmente desaconsejado)
2. `findViewById`
    * Hay que escribir más, y no es tan completa como el binding

````kotlin
findViewById<TextView>(R.id.textView)
````

3. Binding: https://developer.android.com/topic/libraries/view-binding

```kotlin
class MainActivity : AppCompatActivity() {
    
    // activity_main.xml => ActivityMainBinding 
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        // Forma por defecto de obtener vistas:
        // setContentView(R.layout.activity_main) // Comentamos ya que vamos a utilizar binding

        setContentView(view)


        Log.i("MainActivity", "Ejecutando on create")

        val name = "Francisco Javier"
        val textView = findViewById<TextView>(R.id.textView)

        Log.i("MainActivity", textView.text.toString())
    }
}
```

## Eventos y Referencias

**Ids:**

Para poder acceder en nuestro Activity a los elementos visuales que hemos creado en el layout (xml)
todos tienen que tener un id referenciado de esta manera:

```xml
<Button
    android:id="@+id/Enviar"
    android:text="Enviar"
/>
```

Ahora desde nuestro Activity podremos acceder a los datos que contiene o modificarlos:

```kotlin
btEnviar.setOnClickListener {
    // Aquí podemos establecer lo que hará nuestro código una vez pulsado el botón con id Button
}
```
