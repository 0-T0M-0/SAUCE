//FICHIER DE CONFIG POUR WEBPACK

const HtmlWebpackPlugin = require('html-webpack-plugin'); //Plugin pour afficher la page html
const path = require('path');

module.exports = {
    entry: './src/index.js', //Source du js d'index
    output: {
        filename: 'bundle.js', //Nom de l'output
        path: path.resolve(__dirname, 'dist'), //Se trouve dans le dossier dist
        clean: true, // Nettoie le répertoire dist avant chaque build
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader', //Compatibilité avec les vieux navigateurs
                    options: {
                        presets: ['@babel/preset-env'],
                    },
                },
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader'], // Charge le fichier CSS
            },
        ],
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './src/index.html', // Utilise le fichier index.html avec le plugin
        }),
    ],
    devServer: {
        static: {
            directory: path.join(__dirname, 'dist'),
        },
        compress: true,
        port: 9000, //Sur le port 9000
    },
};
