// FICHIER DE CONFIG WEBPACK
const HtmlWebpackPlugin = require('html-webpack-plugin'); //Plugin pour afficher une page html
const path = require('path');

module.exports = {
    entry: './src/index.js', // Le fichier js d'index
    output: {
        filename: 'bundle.js', //Nom du fichier de sortie
        path: path.resolve(__dirname, 'dist'), //Dans le répertoire dist
        clean: true, //Clean
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './src/index.html', // Utilise le fichier index.html comme modèle
        }),
    ],
    devServer: {
        static: {
            directory: path.join(__dirname, 'dist'),
        },
        compress: true,
        port: 9000, //Port de sortie
    }
};
