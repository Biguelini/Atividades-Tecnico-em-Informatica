import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset(
                'logo.png',
                width: 200,
              ),
            ],
          ),
          const Text(
            'Produtos',
            style: TextStyle(fontSize: 24),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(
                child: Column(
                  children: [
                    Text('Prato 1'),
                    Image.asset(
                      'prato.png',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Prato 1'),
                    Image.asset(
                      'prato.png',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Prato 1'),
                    Image.asset(
                      'prato.png',
                      width: 100,
                    ),
                  ],
                ),
              )
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(
                child: Column(
                  children: [
                    Text('Prato 1'),
                    Image.asset(
                      'prato.png',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Prato 1'),
                    Image.asset(
                      'prato.png',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Prato 1'),
                    Image.asset(
                      'prato.png',
                      width: 100,
                    ),
                  ],
                ),
              )
            ],
          ),
          const Text(
            'Restaurantes',
            style: TextStyle(fontSize: 24),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(
                child: Column(
                  children: [
                    Text('Restaurante 1'),
                    Image.asset(
                      'restaurante.jpg',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Restaurante 2'),
                    Image.asset(
                      'restaurante.jpg',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Restaurante 3'),
                    Image.asset(
                      'restaurante.jpg',
                      width: 100,
                    ),
                  ],
                ),
              )
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(
                child: Column(
                  children: [
                    Text('Restaurante 1'),
                    Image.asset(
                      'restaurante.jpg',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Restaurante 2'),
                    Image.asset(
                      'restaurante.jpg',
                      width: 100,
                    ),
                  ],
                ),
              ),
              Container(
                child: Column(
                  children: [
                    Text('Restaurante 3'),
                    Image.asset(
                      'restaurante.jpg',
                      width: 100,
                    ),
                  ],
                ),
              )
            ],
          ),
          FloatingActionButton.large(
            onPressed: (() => {}),
            child: Text("Comprar"),
          )
        ],
      ),
      drawer: Drawer(
          child: Column(
        children: [
          Column(
            children: [
              Image.asset(
                'mylogo.png',
                width: 100,
              ),
              const Text(
                'Big Coding',
                style: TextStyle(fontSize: 24),
              ),
              const Text(
                '42 998349909',
                style: TextStyle(fontSize: 24),
              ),
              const Text(
                'Rua Nelson Basílio Kulcheski, 155',
                style: TextStyle(fontSize: 14),
              ),
            ],
          )
        ],
      ) // Populate the Drawer in the next step.
          ),
    );
  }
}
