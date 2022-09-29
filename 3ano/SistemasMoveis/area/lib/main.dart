import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: const MyHomePage(title: 'Aplicação com Estado'),
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
  double _h = 0, _l = 0, _a = 0;
  final _tH = TextEditingController();
  final _tL = TextEditingController();

  void _calculaArea() {
    setState(() {
      _h = double.parse(_tH.text);
      _l = double.parse(_tL.text);
      _a = _h * _l;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextFormField(
              decoration: const InputDecoration(
                labelText: "Digite a altura",
              ),
              controller: _tH,
            ),
            TextFormField(
              decoration: const InputDecoration(
                labelText: "Digite a largura",
              ),
              controller: _tL,
            ),
            ElevatedButton(
              onPressed: _calculaArea,
              child: const Text('Calcular área'),
            ),
            Text("A área é $_a"),
          ],
        ),
      ),
    );
  }
}
