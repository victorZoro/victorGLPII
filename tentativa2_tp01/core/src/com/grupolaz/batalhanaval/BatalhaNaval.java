package com.grupolaz.batalhanaval;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture; //Deletar caso não usemos
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;



public class BatalhaNaval extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	Table table;
	Vector3 mouse_position;

	/**
	 * Inicializa o ambiente
	 */
	@Override
	public void create () {
		table = new Table(); //Cria novo tabuleiro
		table.createTable(); //Inicializa textura do tabuleiro
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 640, 640);

		mouse_position = new Vector3(0,0,0);
		
		batch = new SpriteBatch();

		mouseClicked();

		Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND); //Calls OpenGL to enable transparency
	}

	/**
	 * Renderiza o jogo.
	 */
	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1); //Limpa tela e aplica cor na tela (red: 255, green: 0, blue: 0, alpha: 255);
		
		camera.update(); //Atualiza a camera

		batch.setProjectionMatrix(camera.combined); //Configura a posição do lote para 0,0

		
		batch.begin(); //Começa a desenhar elementos;
		table.drawTable(batch);
		batch.end(); //Finaliza a rendereização de elementos;
		
		//mouseHover(); //Essa função está causando erro!
	}
	
	/**
	* Confere se o mouse foi clicado e executa ${AÇÃO AQUI}
	*
	* @see source O código desta função foi retirado de uma fonte externa da internet, disponível em: http://gpjecc.blogspot.com/2023/03/libgdx-mariz-na-tela-pegando-posicao-do.html
	*/		
	public void mouseClicked() {
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				mouse_position.set(Gdx.input.getX(), Gdx.input.getY(), 0);
				camera.unproject(mouse_position); //Desprojeta o mouse da tela e dá a ele a origem do mundo (0,0 no canto inferior esquerdo)

				int x = (int)mouse_position.x / table.getTileSize();
				int y = (int)mouse_position.y / table.getTileSize();

				for(Rectangle tile: table.getTiles()) {
					if(tile.contains(x, y)) {
						System.out.println("Clicou em x: " + x + " y: " + y);
						break;
					}
				}
				return super.touchDown(screenX,screenY,pointer,button);
			}
		});
	}

	public void mouseHover() { //Essa função está causando erro!
		mouse_position.set(Gdx.input.getX(), Gdx.input.getY(), 0); //Configura a variável para receber a posição onde o input foi chamado
		
		camera.unproject(mouse_position); //Desprojeta o mouse da tela e dá a ele a origem do mundo (0,0 no canto inferior esquerdo)
		
		float x = mouse_position.x;
		float y = mouse_position.y;

		//table.tableHover();
	}
	
	/**
	 * Limpa a memória após o fim do jogo.
	 */
	@Override
	public void dispose () {
		batch.dispose(); //Libera os recursos do barch;
		table.tableDispose();
	}
}
