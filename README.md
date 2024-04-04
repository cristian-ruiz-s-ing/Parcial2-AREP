# Parcial 2 AREP
### Cristian Camilo Ruiz Santa

Se tienen 3 instancias creadas en Amazon EC2 para las clases `ServiceProxy`, `MathServices` y `MathServices2`

![instancias](/src/main/resources/img/instancias.JPG)
1. **ServiceProxy:** Actúa como un proxy para enrutar las solicitudes de servicio a las instancias de Amazon EC2 que ejecutan los servidores MathServices. Este componente implementa un algoritmo de balanceo de carga `Round Robin` para distribuir equitativamente las solicitudes entre las instancias. Corre en el puerto **4567**.


2. **MathServices:** Proporcionan solucion al problema planteado en el parcial, es decir, dado un número entrega una lista con sus factores y/o los primos existentes desde 1 hasta el número dado, se ejecutan en los puertos **4568** y **4569**.


## Cómo ejecutar y funcionamiento:
Para ejecutar el proyecto se inician las 3 instancias en EC2. Luego, en la consola de cada instancia, se compila el proyecto git que se encuentra clonado y se procede a ejecutar mediante el comando de java para cada caso específico, por ejemplo para el caso del Proxy:
```
sudo java -cp "target/classes:target/dependency/*" org.example.ServiceProxy
```
con esto ya se puede acceder desde el navegador y testear el funcionamiento de las instancias mediante el link que genera la instancia al iniciarse, por ejemplo para el servicio proxy que corre en el puerto **4567**:
```
http://ec2-3-91-215-147.compute-1.amazonaws.com:4567
```
Debería verse así:
![funcionamiento](/src/main/resources/img/Funcionamiento.JPG)


![funcionamiento2](/src/main/resources/img/Funcionamiento2.JPG)

Y en la consola de la máquina que está haciendo de proxy, se evidencia el funcionamiento del algoritmo de **Round Robin** de la sigueinte manera:

![roundrobin](/src/main/resources/img/RoundRobin.JPG)

## Video evidencia:

A continuación se muestra evidencia de su funcionamiento en un corto video:

<video width="320" height="240" controls>
  <source src="/src/main/resources/vid/EvidenciasParcial2AREP.mp4" type="video/mp4">
</video>
