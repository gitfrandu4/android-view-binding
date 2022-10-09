# Vinculación de vista

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
