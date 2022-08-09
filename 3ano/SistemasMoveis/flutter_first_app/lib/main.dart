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
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: home(),
    );
  }

  Widget home() {
    return Container(
      color: Colors.black87,
      child: const Center(
        child: Text(
          'Hello World!',
          style: TextStyle(
            color: Colors.amber,
            fontSize: 64,
            fontWeight: FontWeight.bold,
            fontStyle: FontStyle.italic,
            decoration: TextDecoration.none,
          ),
        ),
      ),
    );
  }
}
