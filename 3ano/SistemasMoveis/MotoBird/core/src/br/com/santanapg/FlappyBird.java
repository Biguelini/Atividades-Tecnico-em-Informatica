package br.com.santanapg;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.Random;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture[] passaros;
	Texture fundo;
	Texture canoBaixo;
	Texture canoTopo;
	Texture gameOver;
	BitmapFont fonte;
	BitmapFont mensagem;
	Rectangle passaroForma;
	Rectangle canoTopoForma;
	Rectangle canoBaixoForma;
	Random numeroRandomico;
	int pontuacao=0;
	float alturaDispositivo, larguraDispositivo;
	float variacao=0;
	float velocidadeQueda=0;
	float posicaoInicialVertical;
	float posicaoMovimentoCanoHorizontal;
	float espacoEntreCanos;
	float alturaEntreCanosRandomica;
	int estadoJogo=0;
	boolean pontuou=false;
	int Y;
	OrthographicCamera camera;
	Viewport viewport;
	final float LARGURAVIRTUAL=768;
	final float ALTURAVIRTUAL=1024;
	@Override
	public void create () {
		pontuacao=0;
		numeroRandomico=new Random();
		alturaDispositivo=ALTURAVIRTUAL;
		larguraDispositivo=LARGURAVIRTUAL;
		posicaoInicialVertical=alturaDispositivo/2;
		posicaoMovimentoCanoHorizontal=larguraDispositivo-100;
		espacoEntreCanos=300;
		batch = new SpriteBatch();
		passaros= new Texture[3];
		passaros[0]=new Texture("passaro1.png");
		passaros[1]=new Texture("passaro1.png");
		passaros[2]=new Texture("passaro1.png");
		canoBaixo=new Texture("cano_baixo.png");
		canoTopo=new Texture("cano_topo.png");
		fundo=new Texture("fundo.png");
		gameOver=new Texture("game_over.png");
		fonte=new BitmapFont();
		mensagem=new BitmapFont();
		fonte.setColor(Color.WHITE);
		fonte.getData().setScale(6);
		mensagem.setColor(Color.WHITE);
		mensagem.getData().setScale(3);
		camera=new OrthographicCamera();
		camera.position.set(LARGURAVIRTUAL/2,ALTURAVIRTUAL/2,0);
		viewport=new StretchViewport(LARGURAVIRTUAL,ALTURAVIRTUAL,camera);
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		camera.update();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		variacao += Gdx.graphics.getDeltaTime() * 10;
		if (variacao > 2) variacao = 0;
		if(estadoJogo==0){
			if(Gdx.input.justTouched()){
				estadoJogo=1;
			}
		}else {

			if (estadoJogo == 1) {
				posicaoMovimentoCanoHorizontal -= Gdx.graphics.getDeltaTime() * 400;
				if(Gdx.input.isTouched()){

					Y=Gdx.input.getY();
					if(Y>= (Gdx.graphics.getHeight()/2)){
						velocidadeQueda=13;
					} else {
						velocidadeQueda=-13;
					}
				} else {
					velocidadeQueda = 0;
				}

				if (posicaoMovimentoCanoHorizontal < -canoTopo.getWidth()) {
					posicaoMovimentoCanoHorizontal = larguraDispositivo;
					alturaEntreCanosRandomica = numeroRandomico.nextInt(400) - 200;
					pontuou = false;
				}
				if(Intersector.overlaps(passaroForma,canoBaixoForma) && !pontuou ||Intersector.overlaps(
						passaroForma,canoTopoForma) && !pontuou){
					estadoJogo = 2;
				} else
				if (posicaoMovimentoCanoHorizontal < 200 && !pontuou) {

					pontuacao++;
					pontuou = true;
				}
			}else{
				if(Gdx.input.justTouched()){
					pontuacao=0;
					estadoJogo=0;
					velocidadeQueda=0;
					posicaoInicialVertical=alturaDispositivo/2;
					posicaoMovimentoCanoHorizontal=larguraDispositivo;
				}
			}
		}
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(fundo, 0, 0, larguraDispositivo, alturaDispositivo);
		batch.draw(canoTopo, posicaoMovimentoCanoHorizontal, alturaDispositivo / 2
				+ espacoEntreCanos / 2 + alturaEntreCanosRandomica);
		batch.draw(canoBaixo, posicaoMovimentoCanoHorizontal, alturaDispositivo /
				2-canoBaixo.getHeight() - espacoEntreCanos/ 2 + alturaEntreCanosRandomica);
		batch.draw(passaros[(int) variacao], 200, posicaoInicialVertical);
		if(estadoJogo==2){
			batch.draw(gameOver,larguraDispositivo/2-gameOver.getWidth()/2,
					alturaDispositivo/2);
			mensagem.draw(batch,"Toque para reiniciar",larguraDispositivo/2-200,
					alturaDispositivo/2);
		}
		fonte.draw(batch,
				Integer.toString(pontuacao),larguraDispositivo/2,alturaDispositivo-50);
		batch.end();
		passaroForma=new
				Rectangle(200,posicaoInicialVertical, passaros[0].getWidth(), passaros[0].getHeight());
		canoTopoForma=new Rectangle(posicaoMovimentoCanoHorizontal,
				alturaDispositivo / 2 + espacoEntreCanos / 2 + alturaEntreCanosRandomica,
				canoTopo.getWidth(),canoTopo.getHeight());
		canoBaixoForma=new Rectangle(posicaoMovimentoCanoHorizontal,
				alturaDispositivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 +
						alturaEntreCanosRandomica, canoBaixo.getWidth(),canoBaixo.getHeight());
		if(posicaoInicialVertical<=0 ||posicaoInicialVertical>=
				alturaDispositivo){
			estadoJogo=2;
		}
		if (posicaoInicialVertical > 0 || velocidadeQueda < 0) {
			posicaoInicialVertical -= velocidadeQueda;
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	@Override
	public void resize(int width, int height) {
		viewport.update(width,height);
	}

}
