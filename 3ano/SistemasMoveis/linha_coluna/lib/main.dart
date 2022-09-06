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
        primarySwatch: Colors.blue,
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
          title: const Text('Linhas e Colunas'),
        ),
        body: Column(
          children: [
            const Text(
              'Oi sou um texto',
              style: TextStyle(fontSize: 40),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Image.asset(
                  "image.jpg",
                  width: 100,
                  height: 200,
                ),
                Image.asset(
                  "image.jpg",
                  width: 100,
                  height: 200,
                ),
                Image.asset(
                  "image.jpg",
                  width: 100,
                  height: 200,
                )
              ],
            ),
            const Text(
              'Oi sou outro texto',
              style: TextStyle(fontSize: 40),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Image.asset(
                  "image.jpg",
                  width: 200,
                  height: 200,
                ),
                Image.asset(
                  "image.jpg",
                  width: 200,
                  height: 200,
                )
              ],
            )
          ],
        ));
  }
}
