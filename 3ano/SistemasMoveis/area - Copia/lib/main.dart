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
      home: const MyHomePage(title: 'Login'),
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
  String _h = '', _l = '', _a = '';
  final _tH = TextEditingController();
  final _tL = TextEditingController();

  void _calculaArea() {
    setState(() {
      _h = _tH.text;
      _l = _tL.text;
      if (_h == 'joao' && _l == 'senha') {
        _a = 'Você está logado!';
      } else {
        _a = 'Senha ou usuário incorreto';
      }
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
                labelText: "Digite o usuário",
              ),
              controller: _tH,
            ),
            TextFormField(
              obscureText: true,
              enableSuggestions: false,
              autocorrect: false,
              decoration: const InputDecoration(
                labelText: "Digite a senha",
              ),
              controller: _tL,
            ),
            ElevatedButton(
              onPressed: _calculaArea,
              child: const Text('Fazer Login'),
            ),
            Text(_a),
          ],
        ),
      ),
    );
  }
}
