package com.grupolaz.batalhanaval;

/*
 * AVISO! APAGAR E REFAZER ESTE CÓDIGO DEPOIS!
 * ESTOU COPIANDO O CÓDIGO DO ÁTILA PRA TESTAR
 * SE ESTÁ FUNCIONANDO!
 * 
 * CASO ESTEJA FUNCIONANDO: REFAZER!!!!!
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.grupolaz.batalhanaval.logic.Game;
import com.grupolaz.batalhanaval.logic.Ship;
import com.grupolaz.batalhanaval.logic.Tile;
import com.grupolaz.batalhanaval.actors.TileActor;
import com.grupolaz.batalhanaval.logic.Board;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;



public class GameScreen extends ScreenAdapter {
    private static final float CHECK_GAMEOVER = 0.5f;
    private static final float PLAY_GAMEOVER = 1f;
    private static final int VIEWPORT_WIDTH = 1280;
    private static final int VIEWPORT_HEIGHT = 720;
    private static final int TILES_PADDING = 1;
    private static final float BACKGROUND_MUSIC_VOLUME = 0.2f;

    final String tile2 = "assets/table/tile2.png";
    final String  tile2_blood = "assets/table/tile2_blood.png";
    final String explosion = "assets/table/explosion.png";
    final String dead_fish = "assets/table/dead_fish.png";
    final String hover = "assets/table/hover.png";
    final String background = "assets/table/background.png";

    private Game game;
    private Board gameTable;
    private int difficulty;

    private BatalhaNaval battleshipGame;
    private Stage stage;
    private Table gdxTable;
    private AssetManager assets;
    private Music backgroundMusic;
    private Sound gameOver_sfx;
    private Timer timer;
    

    public GameScreen(BatalhaNaval battleshipGame, int difficulty) {
        this.battleshipGame = battleshipGame;
        this.difficulty = difficulty;
    }

    @Override
    public void show() {
        loadAssets();
        createGame();
        createInterface();
        createTimer();
    }

    private void loadAssets() {
        assets = new AssetManager();

        assets.load(tile2, Texture.class);
        assets.load(tile2_blood, Texture.class);
        assets.load(explosion, Texture.class);
        assets.load(dead_fish, Texture.class);
        assets.load(hover, Texture.class);
        assets.load(background, Texture.class);

        //Carrega sound effects

        assets.load("sounds/hit.wav", Sound.class);
        assets.load("sounds/miss.wav", Sound.class);
        assets.load("sounds/ship_sunk.wav", Sound.class);
        assets.load("sounds/hover.mp3", Sound.class);
        assets.load("sounds/player_wins.wav", Sound.class);
        assets.load("sounds/player_loses.wav", Sound.class);
        String ig_song = "assets/music/backgroundmusic.wav";
        assets.load(ig_song, Sound.class);
        
        assets.update();
        assets.finishLoading();
        //Carrega a música de fundo
        //backgroundMusic = assets.get(ig_song);
        backgroundMusic.setVolume(BACKGROUND_MUSIC_VOLUME);
     

    }

    private void createGame() {
        List<Ship> ships =  new ArrayList<Ship>();
        
        //Adiciona os navios
        for (int i = 0; i < 10; i++) {
            if(i == 0){
                ships.add(new Ship(1));
            }else if( i != 0 && i <= 2){
                ships.add(new Ship(2));
            }else if(i > 2 && i <= 5){
                ships.add(new Ship(3));
            }else if(i > 5 && i < 10){
                ships.add(new Ship(4));
            }
        }

        //Inicia a classe Game
        this.game = new Game(ships, this.difficulty);
        //Inicia o tabuleiro
        this.gameTable = game.getTable();
    }

    private void createInterface() {
        stage = new Stage(new FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT));
        backgroundMusic.play();

        gdxTable = new Table();
        gdxTable.defaults().pad(TILES_PADDING);

        Point axis = new Point();

        for(axis.x = 0; axis.x < Board.LARGURA; axis.x += 1) {
            for(axis.y = 0; axis.y < Board.ALTURA; axis.y += 1) {
                com.grupolaz.batalhanaval.logic.Tile tile = gameTable.getTile(axis);
                TileActor tileActor = new TileActor(assets, tile, game);
                gdxTable.add(tileActor).size(64);
            }
            gdxTable.row();
        }
    }

    private void createTimer() {
        timer = new Timer();
        Task task = new Task() {
            @Override
            public void run() {
                checkGameOver();
            }
        };

        timer.scheduleTask(task, CHECK_GAMEOVER);
    }

    private void checkGameOver() {
        if(game.isGameOver()) {
            backgroundMusic.stop();

            if(game.isWinner()) {
                gameOver_sfx = assets.get("/gameassets/sounds/player_wins.wav", Sound.class);
                System.out.println("System - O jogador venceu!");
            } else {
                gameOver_sfx = assets.get("/gameassets/sounds/player_loses.wav", Sound.class);
                System.out.println("System - O jogador perdeu!");
            }

            Timer.schedule(new Task() {
                @Override
                public void run() {

                }
            }, PLAY_GAMEOVER);
            
            timer.clear();
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        stage.dispose();
        assets.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        dispose();
    }

}
