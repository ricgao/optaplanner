/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.cloudbalancing.solver.move.factory;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;
import org.optaplanner.core.impl.move.Move;
import org.optaplanner.core.impl.solution.Solution;
import org.optaplanner.examples.cloudbalancing.domain.CloudBalance;
import org.optaplanner.examples.cloudbalancing.domain.CloudComputer;
import org.optaplanner.examples.cloudbalancing.domain.CloudProcess;
import org.optaplanner.examples.cloudbalancing.solver.move.CloudComputerChangeMove;

public class CloudComputerChangeMoveFactory implements MoveListFactory<CloudBalance> {

    public List<Move> createMoveList(CloudBalance cloudBalance) {
        List<Move> moveList = new ArrayList<Move>();
        List<CloudComputer> cloudComputerList = cloudBalance.getComputerList();
        for (CloudProcess cloudProcess : cloudBalance.getProcessList()) {
            for (CloudComputer cloudComputer : cloudComputerList) {
                moveList.add(new CloudComputerChangeMove(cloudProcess, cloudComputer));
            }
        }
        return moveList;
    }

}
