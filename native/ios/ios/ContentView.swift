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
    var body: some View {
        Text(CommonKt.createApplicationScreenMessage())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
