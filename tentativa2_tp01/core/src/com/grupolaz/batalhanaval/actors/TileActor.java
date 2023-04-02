package com.grupolaz.batalhanaval.actors;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.grupolaz.batalhanaval.logic.Tile;
import com.grupolaz.batalhanaval.logic.Game;

public class TileActor extends Actor {
    private Texture tileTexture;
    private AssetManager assets;
    private Game game;
    private Tile tile;
    private boolean isMouseHovering = false;

    /**
     * Construtor do ator da casa do tabuleiro
     * 
     * @param assets - lista de assets a serem carregados
     * @param tile - casa do tabuleiro
     * @param game - parte lógica do jogo
     */
    public TileActor(AssetManager assets, Tile tile, Game game) {
        this.assets = assets;
        this.tile = tile;
        this.game = game;
        this.tileTexture = assets.get("/gameassets/table/tile2.png", Texture.class);

        input();        
    }

    /**
     * Método que é responsável por pegar os inputs em cada casa
     * 
     */
    public void input() {
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) { //Pega o evneto de clique
                Tile tile = TileActor.this.tile;

                if(!tile.isHit() && !TileActor.this.game.isGameOver()) { //Se a casa foi acertada e o jogo não acabou
                    TileActor.this.game.strike(); //Diminui a quantidade de bombas
                    System.out.println("System - Quantidade de bombas = " + TileActor.this.game.getBombCount());
                    tile.setHit(true);

                    if(tile.getCurrentState() == 1) {
                        TileActor.this.assets.get("/gameassets/sound/miss.wav", Sound.class).play(); //Som do erro
                    } else if(tile.getCurrentState() == 2) {
                        if(tile.getShip().isSunk()) {
                            TileActor.this.assets.get("/gameassets/sound/ship_sunk.wav", Sound.class).play(); //Som do naufrágio
                        } else {
                            TileActor.this.assets.get("/gameassets/sound/hit.wav", Sound.class).play(); //Som do acerto
                        }
                    }
                }
                event.stop(); //Para de escutar
            }
            
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) { //Pega o evento do mouse entrando na área
                isMouseHovering = true;
                TileActor.this.assets.get("/gameassets/sound/hover_sfx.mp3", Sound.class).play(); //Som de mouse
                event.stop();
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) { //Pega o evento do mouse saindo da área
                isMouseHovering = false;
                event.stop();
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) { //Desenha por cima da casa
        Texture dead_fish = assets.get("/gameassets/table/dead_fish.png", Texture.class); //Textura de peixe morto
        Texture explosion = assets.get("/gameassets/table/explosion.png", Texture.class); //Textura acerto
        Texture hover = assets.get("/gameassets/table/hover.png", Texture.class); //Textura de seleção

        
        switch(tile.getCurrentState()) {
            case 0: {
                tileTexture = assets.get("/gameassets/table/tile2.png", Texture.class); //Textura de água
            }
            case 1: {
                tileTexture = assets.get("/gameassets/table/tile2_blood.png", Texture.class); //Textura de sangue
            }
            case 2: {
                tileTexture = assets.get("/gameassets/table/tile2.png", Texture.class); //Textura acerto
            }
        }
        
        batch.draw(tileTexture, getX(), getY(), getWidth(), getHeight());
        
        if(tile.getCurrentState() == 1) {
            batch.draw(dead_fish, getX(), getY(), getWidth(), getHeight());
        }else if(tile.getCurrentState() == 2) {
            batch.draw(explosion, getX(), getY(), getWidth(), getHeight());
        }

        if(isMouseHovering) {
            batch.draw(hover, getX(), getY(), getWidth(), getHeight());
        }
    }
}
