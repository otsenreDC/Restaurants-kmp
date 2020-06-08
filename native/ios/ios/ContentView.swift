//
//  ContentView.swift
//  ios
//
//  Created by Ernesto De los Santos Cordero on 6/8/20.
//  Copyright © 2020 Blue Lake. All rights reserved.
//

import SwiftUI
import SharedCode

struct ContentView: View {
    
    @State private var text = CommonKt.createApplicationScreenMessage()
    
    var body: some View {
        
        GetRestaurantsStatsUseCase().execute { (stats) in
            self.text = stats
        }
        
        return Text(text)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


