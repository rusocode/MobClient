/*******************************************************************************
 * Copyright (C) 2014  Rodrigo Troncoso
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
package com.mob.shared.loaders;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;

import com.mob.shared.data.Head;
import com.mob.client.util.Util;

public class HeadLoader extends Loader<Vector<Head>> {

	@Override
	public Vector<Head> load(DataInputStream file) throws IOException {
		Vector<Head> heads = new Vector<Head>();
		int numHeads;

		file.skipBytes(GAME_FILE_HEADER_SIZE);
		numHeads = Util.leShort(file.readShort());
		heads.setSize(numHeads + 1);

		for(int i = 1; i <= numHeads; i++) {
			int headIndex[] = new int[4];

			headIndex[Heading.NORTH.toInt()] = Util.leShort(file.readShort());
			headIndex[Heading.EAST.toInt()] = Util.leShort(file.readShort());
			headIndex[Heading.SOUTH.toInt()] = Util.leShort(file.readShort());
			headIndex[Heading.WEST.toInt()] = Util.leShort(file.readShort());

			heads.setElementAt(new Head(headIndex), i);
		}

		return heads;

	}

}
