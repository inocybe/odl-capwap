/*
 * Copyright (c) 2015 Abi Varghese and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.capwap;

import java.util.ArrayList;

import io.netty.buffer.Unpooled;
import io.netty.buffer.ByteBuf;

/*
import org.opendaylight.capwap.ODLCapwapDiscoveryRequest;
import org.opendaylight.capwap.ODLCapwapDiscoveryResponse;
*/
/*import org.opendaylight.capwap.ODLCapwapMessage;
import org.opendaylight.capwap.ODLCapwapControlMessageFactory;
import org.opendaylight.capwap.ODLCapwapJoinRequest;
import org.opendaylight.capwap.ODLCapwapJoinResponse;
*
/*
import org.opendaylight.capwap.ODLCapwapConfigStatusRequest;
import org.opendaylight.capwap.ODLCapwapConfigStatusResponse;
import org.opendaylight.capwap.ODLCapwapConfigUpdateRequest;
import org.opendaylight.capwap.ODLCapwapConfigUpdateResponse;
import org.opendaylight.capwap.ODLCapwapWTPEventRequest;
import org.opendaylight.capwap.ODLCapwapWTPEventResponse;
import org.opendaylight.capwap.ODLCapwapChangeStateEventRequest;
import org.opendaylight.capwap.ODLCapwapChangeStateEventResponse;
import org.opendaylight.capwap.ODLCapwapEchoRequest;
import org.opendaylight.capwap.ODLCapwapEchoResponse;
import org.opendaylight.capwap.ODLCapwapImageDataRequest;
import org.opendaylight.capwap.ODLCapwapImageDataResponse;
import org.opendaylight.capwap.ODLCapwapResetRequest;
import org.opendaylight.capwap.ODLCapwapResetResponse;
import org.opendaylight.capwap.ODLCapwapPrimaryDiscoveryRequest;
import org.opendaylight.capwap.ODLCapwapPrimaryDiscoveryResponse;
import org.opendaylight.capwap.ODLCapwapDataTransferRequest;
import org.opendaylight.capwap.ODLCapwapDataTransferResponse;
import org.opendaylight.capwap.ODLCapwapClearConfigRequest;
import org.opendaylight.capwap.ODLCapwapClearConfigResponse;
import org.opendaylight.capwap.ODLCapwapStationConfigRequest;
import org.opendaylight.capwap.ODLCapwapStationConfigResponse;
*/

public class ODLCapwapMessageFactory {
 /*   public static ODLCapwapMessage createDiscoveryRequestMessage() {
        ODLCapwapMessage msg = new ODLCapwapDiscoveryRequest();
        return msg;
    }

    public static ODLCapwapMessage createDiscoveryResponseMessage() {
        ODLCapwapMessage msg = new ODLCapwapDiscoveryResponse();
        return msg;
    }
*/
    public static ODLCapwapMessage createJoinRequestMessage(ODLCapwapHeader header, 
        ODLCapwapControlMessage ctrlMsg, 
        ArrayList<ODLCapwapMessageElement> elements) {
        ODLCapwapMessage msg = new ODLCapwapJoinRequest(header, ctrlMsg, elements);
        return msg;
    }
    
    public static ODLCapwapMessage createJoinResponseMessage() {
        
        return null;
    }

    public static ODLCapwapMessage createJoinResponseMessage(ODLCapwapHeader header, 
                                                             ODLCapwapControlMessage ctrlMsg, 
                                                             ArrayList<ODLCapwapMessageElement> elements) {
        ODLCapwapMessage msg = new ODLCapwapJoinResponse(header, ctrlMsg, elements);
        return msg;
    }
    
	
    public static ODLCapwapMessage decodeFromByteArray(byte[] msg) {
        ByteBuf bbuf = Unpooled.wrappedBuffer(msg);
	    
        ODLCapwapHeader header = ODLCapwapHeaderFactory.decodeFromByteBuf(bbuf);
        ODLCapwapControlMessage ctrlMsg = ODLCapwapControlMessageFactory.decodeFromByteBuf(bbuf);
        ArrayList<ODLCapwapMessageElement> elements = ODLCapwapMessageElementFactory.decodeFromByteBuf(bbuf);
	
        ODLCapwapMessage tmpmsg = null;
		
        switch (ctrlMsg.getMessageType()) {
            case ODLCapwapConsts.ODL_CAPWAP_JOIN_REQUEST:
	        tmpmsg = createJoinRequestMessage(header, ctrlMsg, elements);
	        break;
            case ODLCapwapConsts.ODL_CAPWAP_JOIN_RESPONSE:
                tmpmsg = createJoinResponseMessage(header, ctrlMsg, elements);
                break;
        }	
		
        return tmpmsg;
    }
}
