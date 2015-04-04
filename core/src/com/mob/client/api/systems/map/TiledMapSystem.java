/*******************************************************************************
 * Copyright (C) 2015  Rodrigo Troncoso
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package com.mob.client.api.systems.map;

import com.artemis.annotations.Wire;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.mob.client.api.systems.camera.CameraSystem;
import com.mob.client.api.systems.render.MapRenderingSystem;
import com.mob.client.data.Map;
import com.mob.client.handlers.MapHandler;

/**
 * TiledMapSystem Class
 *
 * @author rt
 * @package com.mob.client.api.systems.map
 */
@Wire
public class TiledMapSystem extends VoidEntitySystem {

    // ===========================================================
    // Constants
    // ===========================================================


    // ===========================================================
    // Fields
    // ===========================================================
    public CameraSystem cameraSystem;
    public MapRenderingSystem mapRenderingSystem;
    public Map map;
    public int mapNumber;


    // ===========================================================
    // Constructors
    // ===========================================================
    public TiledMapSystem(int pMapNumber) {
        this.mapNumber = pMapNumber;
    }

    // ===========================================================
    // Methods
    // ===========================================================


    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected void initialize() {
        // Inicializamos el mapa
        this.map = MapHandler.get(this.mapNumber);
        this.map.initialize();
    }

    @Override
    protected void processSystem() {

    }


    // ===========================================================
    // Getter & Setter
    // ===========================================================


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================


}
